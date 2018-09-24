//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
				p.fortify();
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
		//newArmies+= valueOfContinents();
		System.out.print("At the beginning of the turn, " + player.getPlayerName() + " receives " + newArmies + " new armies to be placed.");
		player.reinforce(newArmies);
	}
	
//	//driver method for the reinforce portion of the player turn
//	private void reinforce(){
//		player.reinforce();
//	}
	//counts the number of territories and returns the number of armies the player is supposed to receive
	private int countTerritories(){
		//TODO: *ALSO CALCULATE WHAT CONTINENTS THIS PLAYERS OWNS
		int armiesReturned = player.getnumofterritories() / 3;
		if(armiesReturned < 3)
			return 3;
		else
			return armiesReturned;
	}

	
}
