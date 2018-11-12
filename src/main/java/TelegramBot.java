import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {


    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
    }


    public String getBotUsername() {
        return "RiskTakersBot";
    }

    public String getBotToken() {
        return "705127785:AAEtUvkEgEWnAr2pbaHqHjsNS3Hxmzo1Oyw";
    }
}
