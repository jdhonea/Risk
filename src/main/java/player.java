package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 
 */
public class player {

	public int playerNo;
	public int terrOwned = 0;
	String playerName = new String("");
	int unplacedArmies;
	int numOfDiceRolls;
	int numOfArmies;
	int numOfCards;
	
	boolean canTrade;
	boolean wonWholeGame;
	boolean eliminated;
	boolean win;
	boolean lose;
	boolean ownThisTerr;
	boolean canAttack;
	boolean isAttacking;
	boolean isDefending;
	boolean canDefend;
	
	String[][] playerOptions = new String[2][2];
	//List<territory> adjTerr = new ArrayList<territory>();
	adjacentTerritoriesLists adjTL = new adjacentTerritoriesLists();
	//Contains the cards in the players hand
	List<card>  hand = new ArrayList<card>();
	public List<territory> territoriesOwned = new ArrayList<territory>();
	
	//////////CONSTRUCTORS//////////////////
	public player() {
		
	}
	
	public player(int num) {

		//CHECK FOR EXCEPTIONS
		try {
			if(num > 6) {
				throw new Exception("Too many players!");
			} 
		} catch (Exception e) {
			System.out.println("\nError: " + e.getMessage());
			System.exit(0);
		}
		try {
			if(num < 2) {
				throw new Exception("Not enough players!");
			} 
		} catch (Exception e) {
			System.out.println("\nError: " + e.getMessage());
			System.exit(0);
		}

		this.playerNo = num;
		System.out.print("Player " + this.playerNo + " please enter your name: ");
		Scanner in = new Scanner(System.in);
		this.playerName = in.nextLine();
		if(!Risk_Game.playersN.contains(this.playerName)) {
			Risk_Game.playersN.add(this.playerName);
		}
		else {
			System.out.println("****Cannot have duplicate player names.****");
			new player(this.playerNo);
		}
    }
	public player(int num, int numArmies) {
        this.playerNo = num;
		this.numOfArmies = numArmies;
		System.out.print("Player " + this.playerNo + " please enter your name: ");
		Scanner in = new Scanner(System.in);
		playerName = in.nextLine();
		this.unplacedArmies = numArmies;
		if(!Risk_Game.playersN.contains(playerName)) {
			Risk_Game.playersN.add(playerName);
		}
		else {
			System.out.println("****Cannot have duplicate player names.****");
			this.playerName = "";
			new player( this.playerNo , this.numOfArmies);
		}
    }
	////////////////////////////////////////
	
	/** 
	 * METHODS
	 * 
	 */
	public int getplayernumber() {
		return this.playerNo;
	}

	public void reduceUnplacedArmies(){
		this.unplacedArmies--;
	}

	public int getUnplacedArmies(){
		return this.unplacedArmies;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}

	//territories
	public void setnumofterritories(int n) {

		//CHECK FOR EXCEPTIONS
		try {
			if(n > 42 || n < 0) {
				throw new Exception("Invalid number of territories! Territory number NOT updated.");
			} else {
				this.terrOwned = n;
			}
		} catch (Exception e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}

	public int getnumofterritories() {
		return this.terrOwned;
	}
	
	//dice rolls
	public void setnumofdicerolls(int n) {

		//CHECK FOR EXCEPTIONS
		try {
			if(n > 3 || n < 1) {
				throw new Exception("Invalid number of dice rolls!");
			} else {
				this.numOfDiceRolls = n;
			}
		} catch (Exception e) {
			System.out.println("\nError: " + e.getMessage());
		}
	}
	
	public int getnumofdicerolls() {
		return this.numOfDiceRolls;
	}
	
	//armies
	public void setnumofarmies(int n) {
		this.numOfArmies = n;
	}
	public int getnumofarmies() {
		return this.numOfArmies;
	}
	
	//give player a certain number of cards
	public void setnumofcards(int n) {
		this.numOfCards = n;
	}
	public int getnumofcards() {
		return this.numOfCards;
	}
	
	//set "can trade" status
	public void setCanTrade(boolean trade) {
		this.canTrade = trade;
	}
	public boolean canTrade() {
		return this.canTrade;
	}
	
	//won entire game
	public void setWinner(boolean winner) {
		this.wonWholeGame = winner;
	}
	public boolean getWinner() {
		return this.wonWholeGame;
	}
	
	//when player is eliminated from game
	public void eliminate() {
		
	}
	
	//win battle
	public void setwinnerofbattle(boolean outcome) {
		this.win = outcome;
	}
	public boolean getwinnerofbattle() {
		return this.win;
	}
	
	//lose battle
	public void setloserofbattle(boolean outcome) {
		this.lose = outcome;
	}
	public boolean getloserofbattle() {
		return this.lose;
	}

	//own this territory?
	public boolean ownthisterritory(territory terr) {
		if(terr.isOwnedBy == this.playerNo) {
			return true;
		} else return false;
	}
	
	//if adjacent territory can be attacked.
	//(it might be better to move this method to territory class)
	public void canAttack(territory terr) {
		if(terr.isOwnedBy != this.playerNo) {
			this.canAttack = true;
		} else this.canAttack = false;
	}
	
	//withdraw from a battle
	public void withdraw() {
		
	}
	
	//status of player: 'Attacking' or 'not attacking/defending'
	public void setAttackMode(boolean mode) {
		this.isAttacking = mode;
		this.isDefending = !mode;
	}
	public boolean isAttacking() {
		return this.isAttacking;
	}

	//isDefending
	public void setDefenseMode(boolean mode) {
		this.isAttacking = !mode;
		this.isDefending = mode;
	}
	public boolean isDefending() {
		return this.isDefending;
	}
	
	public void continueAttacking() {
		this.isAttacking = true;
	}
	
	//CHOOSE TERRITORY
	public void chooseTerritory(territory choose) {
		this.territoriesOwned.add(choose);
		this.terrOwned = terrOwned + 1;
		choose.setOwner(playerNo);
	}
	
	//ADD ONE TOKEN/ARMY TO TERRITORY
	public void addTokenToTerritory(territory t) {
		t.addTokenToTerritory();
		t.setOwner(playerNo);
		t.setTaken(true);
	}
	//ADD SPECIFIED # OF TOKENS/ARMIES TO TERRITORY t
	public void addTokensToTerritory(territory t, int tokens) {
		t.addTokensToTerritory(tokens);
		t.setOwner(playerNo);
		t.setTaken(true);
	}
	
	//PRINT TERRITORIES THAT THE PLAYER OWNS
	public void printTerritories() {
		System.out.println("\n"+playerName+" owns: ");
		for(int x = 0; x < territoriesOwned.size(); x++) {
			System.out.print("["+territoriesOwned.get(x).territoryNumber+"]"+territoriesOwned.get(x).name+" (has "+territoriesOwned.get(x).getnumofarmies()+" armies.) \t------>  Adjacent territories: [");
			for(territory t : territoriesOwned.get(x).adj_territories) {
				System.out.print(" "+t.name+",");
			}
			System.out.println("]");
		}
	}
	
	public void getPlayerOptions() {
		/**
		 * If adjacent territory is owned by someone else
		 */
		playerOptions[0][0] = "1";
		playerOptions[0][1] = "Attack enemy";
		/**
		 * 
		 */
		playerOptions[1][0] = "2";
		playerOptions[1][1] = "Reinforce territory";
		
		for(int i = 0; i < playerOptions.length; i++) {
			System.out.println(playerOptions[i][0]+": "+playerOptions[i][1]);
		}
	}
	
	public void rolldice() {
		
	}
	
	public void placeArmy() {
		
	}
	
	public void tradeCards() {
		
	}

	public void pickCard() {

	}

	/**
	 * 
	 */
	public void attack(territory[] tList) {
		String from;
		System.out.println("FROM which territory would you like to attack? *CHOOSE NUMBER*");
		this.printTerritories();

		//Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		try {
			from = reader.readLine();
			int result = Integer.parseInt(from);	
			//check to see if player owns this
			for(territory t : tList) {
				if(t.isOwnedBy == this.playerNo && t.territoryNumber == result) {
					//check if territory has at least 2 armies on it
					if(t.numofArmiesHere > 1) {
						String to;
						System.out.println("Which territory would you like to attack? *CHOOSE NUMBER*");
						int count = 0;
						while(count < t.adj_territories.size()) {
							
							//check ownership again, so to only display territories you can attack
							territory nameCheck = new territory();
							for(territory n : tList) {
								if(t.adj_territories.get(count).name.equals(n.name)) {
									nameCheck = n;
									break;
								}
							}
							
							if(this.getplayernumber() != nameCheck.isOwnedBy+1) {
								System.out.print("["+t.adj_territories.get(count).territoryNumber+"]"+t.adj_territories.get(count).name+"\t(There are ");

									for(territory r : tList) {
										if(r.territoryNumber == t.adj_territories.get(count).territoryNumber) {
											System.out.print(r.numofArmiesHere);
											break;
										}
									}
								System.out.println(" armies here.)");
							}
							count++;
						}
						//Enter data using BufferReader
						BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
						// Reading data using readLine
						try {
							to = reader2.readLine();
							int result2 = Integer.parseInt(to);	
							for(territory tr : tList) {
								//ATTACK
								//TODO: THROW EXCEPTION IF PLAYER ALREADY OWNS THE TERRITORY
								//      HE IS TRYING TO ATTACK, & PROMPT FOR ANOTHER CHOICE
								if(tr.territoryNumber == result2 && this.playerNo != tr.isOwnedBy) {
									System.out.println("\nATTACKING "+tr.name+"!!");
									//COMPLETE THIS METHOD WITH APPROPRIATE ACTIONS
									//TODO: ROLL DICE NEXT
									break;
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("You don't have enough armies to attack from this territory.");
						attack(tList);
					}
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void defend() {

	}

	public void reinforce() {

	}
}
