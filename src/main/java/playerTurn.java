//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.io.Serializable;
import java.util.Scanner;

public class playerTurn implements Serializable{
	boolean valid = true;
	public player player;
	public board board;
	private board savedBoard;
	AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
	/**
	 * CONSTRUCTOR
	 */
	public playerTurn() {

	}
	public playerTurn(player p, board b){
		this.player = p;
		this.board = b;
	}

	/**
	 *************** METHODS ***********************
	 */
	public void chooseOption (player p, territory[] tList, List<player> players, deck deck) throws IOException{
		String attack = "";
		player.resetCardsContainedOwnedTerritory();
		System.out.println(p.getPlayerName() + "'s turn:");
		s3object.writeToFile("game_replay.txt",p.getPlayerName() + "'s turn:\n"); //write output to file & to Amazon S3 bucket

		//STEP 1 REINFORCE
		getNewArmies();
		//STEP 1.5 PURCHASE CREDIT
		//TODO: PURCHASE CREDIT
		//STEP 2 ATTACK (IF DESIRED)
		System.out.println("\n"+p.getPlayerName()+", would you like to attack a territory? (Y or N)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			attack = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(attack.equalsIgnoreCase("Y")) {
			p.attack(tList,players,deck);
		}
		//STEP 3
		p.fortify(tList);
		//END TURN
	}

	//driver method for the player getting and receiving new armies at the beginning of the turn
	private void getNewArmies() throws IOException{
		int newArmies = 0;
		newArmies += countTerritories();
		newArmies+= valueOfContinents();
		System.out.println("Your hand is currently: ");
		s3object.writeToFile("game_replay.txt","Your hand is currently: "); 
		player.printHand();
		//As long as the user controls 3 cards or more, the game will prompt them to trade in a set unless they decline
		while(player.getnumofcards() >= 3){
			System.out.println("Would you like to trade in a set of cards? (Y/N)");
			Scanner input = new Scanner(System.in);
			String option = input.next();
			if(option.equalsIgnoreCase("N"))
				break;
			else{
				//TODO:Handle the user trading in cards
				newArmies += player.tradeCards();
			}

		}
		System.out.print("\nAt the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies for the territories and continents they control.");
		s3object.writeToFile("game_replay.txt","\nAt the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies for the territories and continents they control.\n"); 
		placeNewArmies(newArmies);
	}

	//Has the player place the new armies they just received into territories they own, loops until all armies are placed.
	private void placeNewArmies(int armies){
		//Loops until all new armies are placed
		while (armies > 0){
			player.printTerritories();
//			for(territory n: player.territoriesOwned){
//				System.out.println("[" + n.territoryNumber + "] " + n.getnameofterritory() + " (Currently " + n.getnumofarmies() + " armies here.)");
//			}
			boolean valid = false;
			while(!valid) {
				System.out.print("Please choose a territory you control: ");
				Scanner input = new Scanner(System.in);
				int option = input.nextInt();
				for (territory n : player.territoriesOwned) {
					if (option == n.getTerritoryNumber()){
						System.out.println("\n[" + n.territoryNumber + "] " + n.getnameofterritory() + " (Currently " + n.getnumofarmies() + " armies here.)");
						System.out.println("You currently have " + armies + " to place. Choose a number from 1 to " + armies + " to place that many armies here or 0 to choose another territory.");
						option = input.nextInt();
						if(option > armies){
							valid = false;
							break;
						}
						armies = armies - option;
						n.addTokensToTerritory(option);

						valid = true;
					}
				}
				if(!valid) {
					System.out.println("\nNot a valid input. Try again...");
					player.printTerritories();
				}
			}

		}
	}
	
	//counts the number of territories and returns the number of armies the player is supposed to receive
	public int countTerritories(){
		int armiesReturned = player.getnumofterritories() / 3;
		if(armiesReturned < 3)
			return 3;
		else
			return armiesReturned;
	}

	//calculate the value of the continents the player owns
	private int valueOfContinents(){
		int value = 0;
		for(int n = 0; n < board.getNumOfContinents(); n++){
			continent curr = board.getContinentByNum(n);
			if(curr.getOwner().equals(player.getPlayerName()))
				value += curr.getContinentValue();
			//curr.printContinentTerritories();
		}
		return value;
	}

	//
}
