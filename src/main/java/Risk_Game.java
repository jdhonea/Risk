//package com.risktakers.Risk;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;




/**
 * @author Derrick Ellis, Jason Honea, Ian Voorhies
 *
 */


/**
 * MAIN CLASS
 * 
 */ 
public class Risk_Game {
	//TODO: 2. numOfTerritories should be read from the territories file to allow for using multiple maps
	public static final int numOfTerritories = 42;
	public static List<String> playersN = new ArrayList<String>();
	/**
	 * @return 
	 * 			
	 * @param 
	 * @param  		
	 * @param 
	 * @throws
	 * 			
	 * 			
	 */
	
	//Generates the territory array
	public static void initializeTerritories(territory[] tList) throws Exception{
		//AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
		//TODO: 3. Territories file should have the neighboring territories listed, prevents having to hard-code neighbors, possibly continents too?
		//READ IN LIST OF TERRITORIES FROM FILE
		adjacentTerritoriesLists adjTL = new adjacentTerritoriesLists();
		FileInputStream fstream = new FileInputStream("territory_list.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		System.out.println("");
		//s3object.writeToFile("game_replay.txt","");
		int count = 0;
		while ((strLine = br.readLine()) != null)   {
			tList[count] = new territory(strLine, count + 1, adjTL.get(count));
			count++;
		}
		br.close();
	}
	//Handles the entire territory draft
	public static void territoryDraft(List<player> pList, territory[] tList, int numOfTerritories){
		//AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
		//TODO: Final build needs to be "De-randombized"
		int players = pList.size();
		int currentPlayer = 0;
		int territoriesClaimed = 0;
		/*Creates the random entries for the selection*/
		List<String> randomSelection = new ArrayList<String>();
		for(int n = 1; n <= numOfTerritories; n++){
			randomSelection.add(Integer.toString(n)); 
		}
		Collections.shuffle(randomSelection);
		/*Ends random entries section*/

		while(territoriesClaimed < numOfTerritories){
			System.out.print("\n" + pList.get(currentPlayer).getPlayerName() +":\n");
			//s3object.writeToFile("game_replay.txt","\n" + pList.get(currentPlayer).getPlayerName() +":\n");
			for(int n = 0; n < numOfTerritories; n++){
				if(!tList[n].isTaken()){
					System.out.printf("%-4s", n+1 + ": ");
					//s3object.writeToFile("game_replay.txt","%-4s"+ n+1 + ": ");
					System.out.print(tList[n].getnameofterritory() + "\n");
					//s3object.writeToFile("game_replay.txt",tList[n].getnameofterritory() + "\n");
				}
			}
			System.out.print("\nPlease choose a territory: (number or name) ");
			//s3object.writeToFile("game_replay.txt","\nPlease choose a territory: (number or name) ");
			boolean noTerritorySelected = true;
			while(noTerritorySelected){
				String selection;
				//Needs to be uncommented later, for now is not used due to random selection
				//Scanner in = new Scanner(System.in);
				//selection = new String(in.nextLine());
				//in.close();
				//---------------------------------------
				//Random Randomizer - Comment out in final build!
				selection = randomSelection.get(0);
				randomSelection.remove(0);
				//Ends Randomizer;
				for(int n = 0; n < numOfTerritories; n++){
					if((tList[n].getnameofterritory().equals(selection) || Integer.toString(tList[n].getTerritoryNumber()).equals(selection)) && !tList[n].isTaken()){
						tList[n].setTaken(true);
						tList[n].setOwner(currentPlayer);
						tList[n].setOwnerName(pList.get(currentPlayer).getPlayerName());
						tList[n].addTokenToTerritory();
						pList.get(currentPlayer).chooseTerritory(tList[n]);
						noTerritorySelected = false;
						pList.get(currentPlayer).reduceUnplacedArmies();
						break;
					}
				}
				if(noTerritorySelected){
					System.out.print("Not a valid selection. Please Try again: ");
					//s3object.writeToFile("game_replay.txt","Not a valid selection. Please Try again: ");
				}
			}
			currentPlayer = (currentPlayer + 1) % players;
			territoriesClaimed++;
		}
		//Placing Remaining Armies Begin
		System.out.print("\nAll territories claimed!\n");
		//s3object.writeToFile("game_replay.txt","\nAll territories claimed!\n");
		int playersWithArmiesRemaining = 0;
		while(playersWithArmiesRemaining != players){
			System.out.print("\n" + pList.get(currentPlayer).getPlayerName() + "\'s owned territories: (Remaining Armies " + pList.get(currentPlayer).getUnplacedArmies() + ")\n");
			//s3object.writeToFile("game_replay.txt","\n" + pList.get(currentPlayer).getPlayerName() + "\'s owned territories: (Remaining Armies " + pList.get(currentPlayer).getUnplacedArmies() + ")\n");
			System.out.print("Territory \t\t\t Number of Armies\n------------------------------------------------------------------\n");
			//s3object.writeToFile("game_replay.txt","Territory \t\t\t Number of Armies\n------------------------------------------------------------------\n");
			//Used for randomizing only!
			List<territory> randomTerritory = new ArrayList<territory>();
			for (int n = 0; n < numOfTerritories; n++){
				if(tList[n].getOwner() == (currentPlayer+1)){
					System.out.printf("%-4s %-30s %-30d", tList[n].getTerritoryNumber() + ": ", tList[n].getnameofterritory(), tList[n].getnumofarmies());
					//s3object.writeToFile("game_replay.txt","%-4s %-30s %-30d"+ tList[n].getTerritoryNumber() + ": "+ tList[n].getnameofterritory() +" "+ tList[n].getnumofarmies());
					System.out.print("\n");
					//s3object.writeToFile("game_replay.txt","\n");
					//Used for randomizing only!
					randomTerritory.add(tList[n]);

				}
			}
			//Used for randomizing only!
			Collections.shuffle(randomTerritory);
			System.out.print("Choose a territory to add an army to: ");
			//s3object.writeToFile("game_replay.txt","Choose a territory to add an army to: ");
			boolean noTerritorySelected = true;
			while(noTerritorySelected){
				String selection;
				//Used for randomizing only!
				selection = Integer.toString(randomTerritory.get(0).getTerritoryNumber());
				//Uncomment in final build - commented for testing purposes only
				//Scanner in = new Scanner(System.in);
				//selection = new String(in.nextLine());
				//in.close();
				for(int n = 0; n < numOfTerritories; n++){
					if((tList[n].getnameofterritory().equals(selection) || Integer.toString(tList[n].getTerritoryNumber()).equals(selection)) && tList[n].getOwner() == currentPlayer+1){
						tList[n].addTokenToTerritory();
						noTerritorySelected = false;
						pList.get(currentPlayer).reduceUnplacedArmies();
						break;
					}
				}
				if(noTerritorySelected){
					System.out.print("Not a valid selection. Please Try again: ");
					//s3object.writeToFile("game_replay.txt","Not a valid selection. Please Try again: ");
				}
				//in.close();
			}
			currentPlayer = (currentPlayer + 1) % players;
			playersWithArmiesRemaining = 0;
			for(int n = 0; n < players; n++){
				if(pList.get(n).getUnplacedArmies() == 0){
					playersWithArmiesRemaining++;
				}
			}

		}
	}

	/**
	 * METHOD THAT DETERMINES NUMBER OF ARMIES EACH PLAYERS RECEIVES
	 * AND GIVES THE ARMIES TO EACH PLAYER
	 */
	//public static void newArmies(int players, List<player> pList) {
		
	//}

	public static void main(String[] args) throws Exception{
		//text();
		//ESTABLISH MAIN VARIABLES
		
		AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
		s3object.clearFileContents(); //make sure file contents are cleared
		
		//ESTABLISH MAIN VARIABLES
		String numOfPlayers;
		int players = 0;
		boolean valid = true;
		byte[] boardData; //stores the board state for the undo feature
		territory[] tList = new territory[numOfTerritories]; //list of all territories
		List<String> playerNames = new ArrayList<String>();
		// CALLING METHOD THAT PUTS THE PLAYERS INTO A STRING ARRAY.
		List<player> pList = new ArrayList<player>(players);
		//*****************START GAME. PROMPT USER FOR NUMBER OF PLAYERS***************
		while(valid) {
			String welcome = "WELCOME TO RISK! LET'S PLAY!\n";
			System.out.println(welcome);
			s3object.writeToFile("game_replay.txt",welcome); //write output to file & to Amazon S3 bucket
			String howmany = "How many players? \n";
			System.out.print(howmany);
			s3object.writeToFile("game_replay.txt",howmany);

			//Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			numOfPlayers = reader.readLine();
			s3object.writeToFile("game_replay.txt",numOfPlayers);
			players = Integer.parseInt(numOfPlayers);

			//CHECK IF NUMBER OF PLAYERS IS VALID
			if(players > 1 && players < 7) {
				valid = false;
			} else {
				if(players < 2) {
					System.out.println(numOfPlayers + " is not enough players. Need at least 2.");
					s3object.writeToFile("game_replay.txt",numOfPlayers + " is not enough players. Need at least 2.");
				} else {
					System.out.println(numOfPlayers + " is too many players. Can only have up to 6.");
					s3object.writeToFile("game_replay.txt",numOfPlayers + " is too many players. Can only have up to 6.");
				}
				System.out.println("");
				s3object.writeToFile("game_replay.txt","");
			}
		}

		initializeTerritories(tList);

		//INITIALIZE GAME BOARD
		deck deck = new deck(42);
		@SuppressWarnings("unused")
		board gameBoard = new board(tList, deck);

		//GIVE OUT ARMIES BASED ON NUMBER OF PLAYERS
		//newArmies(players,pList);
		if(players == 2) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,40));
			}
		}
		else if(players == 3) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,35));
			}
		}
		else if(players == 4) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,30));
			}
		}
		else if(players == 5) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,25));
			}
		}
		else if(players == 6) {
			for(int x = 1; x <= players; x++) {
				pList.add(new player(x,20));
			}
		}
		
		
		//Update pList after entering names
		for(int p = 0; p < playersN.size(); p++) {
			pList.get(p).playerName = playersN.get(p);
		}
		
		//FOR REFERENCE
		System.out.println("\nAll players get " + pList.get(0).getnumofarmies() + " armies.");
		s3object.writeToFile("game_replay.txt","\nAll players get " + pList.get(0).getnumofarmies() + " armies.");

		//DETERMINE THE ORDER OF PLAY
		Collections.shuffle(pList);
		System.out.println("");
		s3object.writeToFile("game_replay.txt","");
		List<player> playerOrder = new ArrayList<player>(players);
		for(int x = 0; x < players; x++) {
			playerOrder.add(pList.get(x));
		}
		System.out.println("*ROLLING DICE TO DETERMINE ORDER OF PLAY.*"+"\nPLEASE WAIT...");
		//s3object.writeToFile("game_replay.txt","\n*ROLLING DICE TO DETERMINE ORDER OF PLAY.*"+"\nPLEASE WAIT...");
		//TimeUnit.SECONDS.sleep(3);
		System.out.print("\nThe order of play is: ");
		s3object.writeToFile("game_replay.txt","\nThe order of play is: ");
		for(int x = 0; x < players; x++) {
			System.out.print(playerOrder.get(x).getPlayerName() + " ");
			s3object.writeToFile("game_replay.txt",playerOrder.get(x).getPlayerName() + " "); 
		}
		System.out.println("\n");
		s3object.writeToFile("game_replay.txt","\n");
		//TimeUnit.SECONDS.sleep(3);
		/**
		 * PLAYERS ARE CHOOSING THEIR TERRITORIES
		 * CURRENTLY, THIS IS SIMULATING THE PLAYERS CHOOSING
		 * BUT IN THE FUTURE, THIS WILL BE A USER INPUT PROCESS
		 * 
		 */
		System.out.println("*PLAYERS, CLAIM YOUR TERRITORIES!*");
		s3object.writeToFile("game_replay.txt","\n*PLAYERS, CLAIM YOUR TERRITORIES!*");
		//************************TERRITORY DRAFT BEGIN***************
		/*****************************KNOWN ISSUES!!!!!
		 * During Draft phase, empty strings throws an exception at the parseInt
		 */
		territoryDraft(pList, tList, numOfTerritories);

		//************************TERRITORY DRAFT END*****************

		System.out.println("\n\nAll armies have been placed.\nNow let's begin!");
		s3object.writeToFile("game_replay.txt","\n\nAll armies have been placed.\nNow let's begin!\n");
		gameBoard.setPlayerList(pList);
		gameBoard.setDeck(deck);
		for (player n : pList){
			n.setBoard(gameBoard);
		}

		//********************GAMEPLAY BEGINS****************************
		boolean weHaveAWinner = false;
		int currentplayer = 0;
		while(weHaveAWinner == false) {
			boardData = saveState(gameBoard);
			player p = pList.get(currentplayer);
			//new playerTurn object
			playerTurn pT = new playerTurn(p, gameBoard);

			if(!p.wonWholeGame) {
				pT.chooseOption(p, tList, pList,deck);
			}
			//if end returns true, ie player ends turn
			if(end())
				p.endturn();
			else{
				System.out.println("Undoing current turn...");
				s3object.writeToFile("game_replay.txt","Undoing current turn...\n");
				currentplayer--;
				gameBoard = restoreData(boardData);
				deck = gameBoard.getDeck();
				pList = gameBoard.getPlayerList();
			}
			currentplayer = ++currentplayer % pList.size();
		}

	}

	//saves the current board state using serialization
	private static byte[] saveState(board gameBoard){
		byte[] boardData;
		try {
			//Breaks down the object gameBoard into an array of bytes, stores it in the boardData array and returns it.
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			ObjectOutputStream output = new ObjectOutputStream(stream);
			output.writeObject(gameBoard);
			boardData = stream.toByteArray();
			output.flush();
			output.close();
			stream.close();
		}
		catch(IOException exception){
			System.out.println("Exception caught");
			return new byte[0];
		}
		return boardData;
	}
	//TODO: Looks like the adjacent territories lists do not get updated upon the restore. Needs to be figured out and fixed.
	//reads the boardData byte array and restores the board state to the previous state.
	private static board restoreData(byte[] boardData){
		board restoredBoard = new board();
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(boardData);
			ObjectInputStream in = new ObjectInputStream(input);
			restoredBoard = (board)in.readObject();
		}
		catch(IOException exception){
			System.out.println("IOException found!");
		}
		catch(ClassNotFoundException exception){
			System.out.println("ClassNotFoundException caught");
		}
		return restoredBoard;
	}

	//Prompts the player to end their turn
	private static boolean end(){
		System.out.println("Would you like to end your turn 'Y' or undo changes 'U'?");
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		while(!valid) {
			String option = in.next();
			if (option.equalsIgnoreCase("Y"))
				return true;
			else if (option.equalsIgnoreCase("U"))
				return false;
			else
				System.out.println("Not a correct option.");
		}
		return true;
	}

	//Displays the "Splash Screen and game text"
	private static void text() throws Exception{
		System.out.println("Authors: Derrick Ellis, Jason Honea, Ian Voorhies");
		System.out.print("\n" +
				"                                                                                           \n" +
				"              ,,                                                                           \n" +
				"`7MM\"\"\"Mq.    db         `7MM          MMP\"\"MM\"\"YMM      `7MM                              \n" +
				"  MM   `MM.                MM          P'   MM   `7        MM                              \n" +
				"  MM   ,M9  `7MM  ,pP\"Ybd  MM  ,MP'         MM   ,6\"Yb.    MM  ,MP'.gP\"Ya `7Mb,od8 ,pP\"Ybd \n" +
				"  MMmmdM9     MM  8I   `\"  MM ;Y            MM  8)   MM    MM ;Y  ,M'   Yb  MM' \"' 8I   `\" \n" +
				"  MM  YM.     MM  `YMMMa.  MM;Mm            MM   ,pm9MM    MM;Mm  8M\"\"\"\"\"\"  MM     `YMMMa. \n" +
				"  MM   `Mb.   MM  L.   I8  MM `Mb.          MM  8M   MM    MM `Mb.YM.    ,  MM     L.   I8 \n" +
				".JMML. .JMM..JMML.M9mmmP'.JMML. YA.       .JMML.`Moo9^Yo..JMML. YA.`Mbmmd'.JMML.   M9mmmP' \n" +
				"                                                                                           \n" +
				"                                                                                           \n");
		System.out.println(String.format("%50s","Proudly presents..."));
		TimeUnit.SECONDS.sleep(5);
		System.out.println(new String(new char[50]).replace("\0", "\r\n"));
		System.out.print("\n" +
				" _______   ______   ______   __    __ \n" +
				"|       \\ |      \\ /      \\ |  \\  /  \\\n" +
				"| $$$$$$$\\ \\$$$$$$|  $$$$$$\\| $$ /  $$\n" +
				"| $$__| $$  | $$  | $$___\\$$| $$/  $$ \n" +
				"| $$    $$  | $$   \\$$    \\ | $$  $$  \n" +
				"| $$$$$$$\\  | $$   _\\$$$$$$\\| $$$$$\\  \n" +
				"| $$  | $$ _| $$_ |  \\__| $$| $$ \\$$\\ \n" +
				"| $$  | $$|   $$ \\ \\$$    $$| $$  \\$$\\\n" +
				" \\$$   \\$$ \\$$$$$$  \\$$$$$$  \\$$   \\$$\n" +
				"                                      \n" +
				"                                      \n" +
				"                                      \n");
	}

}
