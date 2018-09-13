//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class playerTurn{
	boolean valid = true;

	/**
	 * CONSTRUCTOR
	 */
	public playerTurn() {

	}

	/**
	 *************** METHODS ***********************
	 */
	public void chooseOption(player p, territory[] tList, List<player> players) {
		String optionNumber = new String();
		valid = true;
		while(valid) {
			System.out.println("\n"+p.getPlayerName()+", what would you like to do? CHOOSE NUMBER\n");
			p.getPlayerOptions();
			//Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// Reading data using readLine
			try {
				optionNumber = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(optionNumber.equals("1")) {
				valid = false;
				//ATTACK
				p.attack(tList,players);
				break;
			}
			if(optionNumber.equals("2")) {
				valid = false;
				//REINFORCE
				p.reinforce();
				break;
			}
			else {
				System.out.println("Invalid choice. Try again....");
				valid = true;
			}
		}
	}

	public void getNewArmies() {

	}
	
}
