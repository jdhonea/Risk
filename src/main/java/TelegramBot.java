import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.*;
import java.util.*;

public class TelegramBot extends TelegramLongPollingBot {
    private Properties prop = new Properties();
    private  String RISKBOT_TOKEN;
    private  String RISKBOT_TOKEN_SECRET;
    private boolean gameInSession = false;
    private HashMap<Long, String> storedCommands = new HashMap();

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        String text = update.getMessage().getText();
        long chatID = update.getMessage().getChatId();
        //Handles the /start command
        if(text.equals("/start") && !gameInSession){
            gameInSession = true;
            send("Please give a 4-digit game ID number:", chatID);
            storedCommands.put(chatID, "/start");
        }
        //Handles the /join command
        else if(text.equals("/join")){
            if(gameInSession){
                send("Please enter the 4-digit game ID number:", chatID);
                storedCommands.put(chatID, "/join");
            }
            else{
                send("There is not a game currently in session. Type /start to create a new game.", chatID);
            }
        }
        else{
            /*
            0 = no previous command
            1 = /start
            2 = /join
             */
            int selector = checkForPreviousCommand(chatID);
            if (selector == 1){
                send("Game number: " + text + " created. Waiting for more players...", chatID);
                Risk_Game.gameID = Integer.parseInt(text);
                List<player> pList = Risk_Game.gameBoard.getPlayerList();
                pList.add(new player(chatID));
                //System.out.println(pList.size());

            }
            else if(selector == 2){
                send("Joining game number " + text + ".", chatID);
                if(Integer.parseInt(text) == Risk_Game.gameID)
                    newPlayer(chatID);
            }
            else if(selector == 0){

            }
        }
    }

    /**
     * Checks the HashMap for previous user commands to choose what role the next input should be.
     * @return integer value for case switching
     */
    private int checkForPreviousCommand(long chatID){
        String value = storedCommands.get(chatID);
        if(value == null)
            return 0;
        else if (value == "/start") {
            storedCommands.remove(chatID);
            return 1;
        }
        else if (value == "/join") {
            storedCommands.remove(chatID);
            return 2;
        }
        return -1;
    }

    public String getBotUsername() {
        return "RiskTakersBot";
    }

    public String getBotToken() {
        loadPropertyFile("secrets_RISK_TAKERS.prop");
        return RISKBOT_TOKEN + ":" + RISKBOT_TOKEN_SECRET;
    }

    /**
     * Sends a message to the user by their chat ID.
     * @param text String to be sent to the player
     * @param chatID Player's chat ID
     * @return returns 0 if successful, -1 if not.
     */
    public int send(String text, long chatID){
        SendMessage message = new SendMessage().setChatId(chatID).setText(text);
        try {
            execute(message);
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int sendAll(String text){
        for (player n : Risk_Game.gameBoard.getPlayerList()){
            SendMessage message = new SendMessage().setChatId(n.getChatID()).setText(text);
            try {
                execute(message);
            }
            catch (TelegramApiException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    // "secrets_RISK_TAKERS.prop"
    private void loadPropertyFile( String filename ) {
        BufferedReader input = null;
        try {
            // open file for reading
            input = new BufferedReader(new FileReader(filename));

            // load a properties file
            prop.load(input);

            RISKBOT_TOKEN = prop.getProperty("telegram-token");
            RISKBOT_TOKEN_SECRET = prop.getProperty("telegram-token-secret");

        } catch (FileNotFoundException ignored) {
            System.out.println("Sorry, unable to find file: " + filename);
        } catch (IllegalArgumentException ignored) {
            System.out.println("Sorry, malformed characters in file: " + filename);
        } catch (IOException ex) {
            System.out.println("Sorry, unknown error occurred when reading from file: " + filename);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Sorry, unknown error occurred when closing file: " + filename);
                    e.printStackTrace();
                }
            }
        }
    }
    private  int newPlayer(long chatID){
        List<player> pList = Risk_Game.gameBoard.getPlayerList();
        System.out.println(pList.size());
		/*for(player n : pList){
			if(chatID == n.getChatID()){
				send("You are already in this game.", chatID);
				return -1;
			}
		}*/
        pList.add(new player(chatID));
        return 0;
    }
}
