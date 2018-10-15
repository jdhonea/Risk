//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Keeps track of the current turn order and makes sure that turn order is preserved.
 */

public class playerTurn implements Serializable{
	boolean valid = true;
	public player player;
	public board board;
	private board savedBoard;
	AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
	/**
	 * Default constructor
	 */
	public playerTurn() {

	}

	/**
	 * Creates a new turn for the player who's turn it is currently containing the game board.
	 * @param p the current active player
	 * @param b	the game board
	 */
	public playerTurn(player p, board b){
		this.player = p;
		this.board = b;
	}

	/**
	 *************** METHODS ***********************
	 */

	/**
	 * Progresses the player through their turn, preserving order.
	 * @param p	current player
	 * @param tList	the list of territories
	 * @param players	the list of other players
	 * @param deck	the list of cards that make up the deck
	 * @throws IOException
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

	/**
	 * The driver method to handle and calculate the player getting and placing new armies received at the beginning of each turn
	 * @throws IOException
	 */
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
				newArmies += player.tradeCards();
			}

		}
		System.out.print("\nAt the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies for the territories and continents they control.");
		s3object.writeToFile("game_replay.txt","\nAt the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies for the territories and continents they control.\n"); 
		placeNewArmies(newArmies);
	}

	/**
	 * Leads the player through placing their new armies received at the beginning of the turn. Continues to loop until all armies are placed.
	 * @param armies	the number of armies received at the beginning of the turn
	 */
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

	/**
	 * Counts the number of territories the current player owns and returns the number of armies they are supposed to receive.
	 * @return	the number of armies the player is to receive
	 */
	public int countTerritories(){
		int armiesReturned = player.getnumofterritories() / 3;
		if(armiesReturned < 3)
			return 3;
		else
			return armiesReturned;
	}

	/**
	 * Calcuates the value of the continents the current player owns.
	 * @return the value of the continents owned by the current player
	 */
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

}
