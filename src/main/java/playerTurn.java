//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class playerTurn{
	boolean valid = true;
	private player player;
	private board board;
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
	public void chooseOption(player p, territory[] tList, List<player> players) {
		String attack = "";
		valid = true;
		while(valid) {
			//STEP 1 REINFORCE
			getNewArmies();
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
				p.attack(tList,players);
			}
			//STEP 3
			//TODO: EXECUTE FORTIFY HERE!
			else {
				fortify();
			}
			//END TURN
			p.endturn();
			// Reading data using readLine
//			try {
//				optionNumber = reader.readLine();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if(optionNumber.equals("1")) {
//				//TODO:REINFORCE (getting and placing new armies)
//				reinforce();
//				valid = false;
//			}
//			else if(optionNumber.equals("2")) {
//				//ATTACK
//				p.attack(tList,players);
//			}
//			else if(optionNumber.equals("3")) {
//				valid = false;
//				//REINFORCE
//				p.endturn();
//			}
//			else {
//				System.out.println("Invalid choice. Try again....");
//				valid = true;
//			}
		}
	}
	//driver method for the player getting and receiving new armies at the beginning of the turn
	private void getNewArmies() {
		int newArmies = 0;
		newArmies += countTerritories();
		newArmies+= valueOfContinents();
		System.out.println("Your hand is currently: ");
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
			}

		}
		System.out.print("At the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies for the territories and continents they control.");
		placeNewArmies(newArmies);
	}

	//Has the player place the new armies they just received into territories they own, loops until all armies are placed.
	private void placeNewArmies(int armies){
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
	
	//driver method for the reinforce portion of the player turn
	private void fortify(){

	}

	//counts the number of territories and returns the number of armies the player is supposed to receive
	private int countTerritories(){
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
			if(!curr.getOwner().equals(""))
				value += curr.getContinentValue();
			//curr.printContinentTerritories();
		}
		return value;
	}

}
