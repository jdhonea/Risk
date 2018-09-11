package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CONSTRUCTOR
 */
public class playerTurn{
	public playerTurn(player p, territory[] tList) {
		String optionNumber = new String();
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

		for(int i = 0; i < p.playerOptions.length; i++) {
			if(optionNumber.equals(p.playerOptions[i][0])) {
				if(optionNumber.equals("1")) {
					//ATTACK
					p.attack(tList);
				}
				else if(optionNumber.equals("2")) {
					//REINFORCE
					p.reinforce();
				}
				break;
			}
		}
	}
}
