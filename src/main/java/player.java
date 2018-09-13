//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		if(isDefending) {
			isAttacking = false;
		} else isAttacking = true;
		return this.isAttacking;
	}

	//isDefending
	public void setDefenseMode(boolean mode) {
		this.isAttacking = !mode;
		this.isDefending = mode;
	}
	public boolean isDefending() {
		if(isAttacking) {
			isDefending = false;
		} else isDefending = true;
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
		
		playerOptions[1][0] = "2";
		playerOptions[1][1] = "Reinforce territory";
		
		for(int i = 0; i < playerOptions.length; i++) {
			System.out.println(playerOptions[i][0]+": "+playerOptions[i][1]);
		}
	}
	
	/**
     * Returns an integer array of values between 1 and 6 representing the
     * outcome of rolling the dice.  The number of values in the array should be
     * between 1 and 3, depending on the number of dice rolled by the player.  The 
     * number of dice rolled by the player is determined by the argument diceDeterminant
     **/
	public int[] rolldice(int diceDeterminant) {
		String input = null;
		int numberOfDiceRolls = 0;
		int[] playerDice;
		int max = 1;
		if(this.isAttacking) {
			if(diceDeterminant == 2) {
				max = 1;
			}
			if(diceDeterminant == 3) {
				max = 2;
			}
			if(diceDeterminant > 3) {
				max = 3;
			}
		} else if (this.isDefending) {
			if(diceDeterminant == 1) {
				max = 1;
			}
			if(diceDeterminant > 1) {
				max = 2;
			}
		}
		boolean check = true;
		while(check) {
			System.out.println(this.playerName+", you have "+diceDeterminant+" armies here.");
			System.out.println("You may roll up to "+max+" dice. How many dice do you want to roll?");
			//Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// Reading data using readLine
			try {
				input = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			numberOfDiceRolls = Integer.parseInt(input);
			if(numberOfDiceRolls < 1 || numberOfDiceRolls > max) {
				check = true;
				System.out.println("***Invalid input. TRY AGAIN.***\n");
			} else {
				check = false;
			}
		}
		
		System.out.println(this.playerName+" is rolling "+numberOfDiceRolls+" dice...");
		Dice dice = new Dice();	
		playerDice = dice.roll(numberOfDiceRolls);	
		Arrays.sort(playerDice);
		System.out.print("Dice Results = [ ");
		for(int i : playerDice) {
			System.out.print(i+" ");
		}
		System.out.print("]");
		return playerDice;
	}
	
	
	public void placeArmy() {
		
	}
	
	public void tradeCards() {
		
	}

	public void pickCard() {

	}
	
	/**
	 * Updating number of armies on each territory after battle
	 * 
	 */
// 	public void updateTerritoriesAfterBattle(territory attackingFrom, int attackerLost, territory defendingFrom, int defenderLost) {
// 		attackingFrom.setnumberofarmies(attackingFrom.getnumofarmies()-attackerLost);
// 		defendingFrom.setnumberofarmies(defendingFrom.getnumofarmies()-defenderLost);
		
// 		//TODO: FIGURE OUT HOW TO SWITCH OWNERSHIP OF TERRITORY WHEN NEEDED
// 		if(defendingFrom.getnumofarmies() < 1) {
// 			defendingFrom.setOwner(attackingFrom.isOwnedBy);
// 			defendingFrom.setOwnerName(attackingFrom.ownerName);
// 			System.out.print("***"+defendingFrom.name+" has been conquered by "+attackingFrom.ownerName+"!!**\n");
// 		}
// 	}
	
	/**
	 * Comparing dice rolls to determine outcome of battle
	 * RETURNS INT[] CONTAINING NUMBER OF ARMIES LOST FOR EACH PLAYER'S TERRITORY
	 * RETURN int[] outcome[numberOfArmiesLostByAttacker, numberOfArmiesLostByDefender]
	 */
	public int[] compareDiceRolls(player p1,int[] p1Dice,player p2,int[] p2Dice) {
		int[] outcome = new int[2];
		int defenderLosses = 0;
		int attackerLosses = 0;
		System.out.print("\n\nCOMPARING RESULTS....");
		System.out.print("\n"+p1.getPlayerName()+": [");
		for(int p : p1Dice) {
			System.out.print(p+" ");
		}
		System.out.print("]");
		
		System.out.print("\n"+p2.getPlayerName()+": [");
		for(int p : p2Dice) {
			System.out.print(p+" ");
		}
		System.out.println("]");
		
		//if defender only rolls one die
		if(p2Dice.length == 1 || p1Dice.length == 1) {
			if(p1Dice[p1Dice.length-1] > p2Dice[p2Dice.length-1]) {
				defenderLosses++;
			} else attackerLosses++;
		} 
		//if both roll two dice
		if (p2Dice.length == 2 && p1Dice.length == 2) {
			for(int i = 0; i < 2; i++) {
				if(p1Dice[i] > p2Dice[i]) {
					defenderLosses++;
				} else attackerLosses++;
			}
		}
		//if attacker rolls 3 & defender rolls 2
		if (p2Dice.length == 2 && p1Dice.length > 2) {
			int[] resizedArray = new int[2];
			int newSize = p1Dice.length - p2Dice.length;
			int counter = 0;
			while(counter < 2) {
				resizedArray[counter] = p1Dice[p1Dice.length - 1 - newSize];
				counter++;
				newSize--;
			}
			for(int i = 0; i < 2; i++) {
				if(resizedArray[i] > p2Dice[i]) {
					defenderLosses++;
				} else attackerLosses++;
			}
		}
		
		System.out.println(p1.getPlayerName()+" lost "+attackerLosses+" armies.");
		System.out.println(p2.getPlayerName()+" lost "+defenderLosses+" armies.");
		outcome[0] = attackerLosses;
		outcome[1] = defenderLosses;
		return outcome;
		
	}

	/**
	 * 
	 */
	public void attack(territory[] tList, List<player> players) {

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
					t.setOwnerName(this.playerName);
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
							
							if(this.getplayernumber() != nameCheck.isOwnedBy) {
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
								//TODO: THROW EXCEPTION IF INPUT IS INVALID & PROMPT FOR ANOTHER CHOICE
								if(tr.territoryNumber == result2 && this.playerNo != tr.isOwnedBy) {
									//COMPLETE THIS METHOD WITH APPROPRIATE ACTIONS
									this.setAttackMode(true);
									territory diceTerr = new territory();
									diceTerr = tList[result-1];
									int[] attackingP = this.rolldice(diceTerr.getnumofarmies());
									System.out.println("\n\n***ATTACKING "+tr.name+"!!***\n");
									boolean tryagain = true;
									int next = 0;
									tr.setOwnerName(players.get(next).playerName);
									while(tryagain) {
										if(tr.isOwnedBy == players.get(next).playerNo) {
											System.out.println(players.get(next).playerName+", you must DEFEND your territory!");
											players.get(next).setDefenseMode(true);
											tryagain = false;
											break;
										}
										next++;
									}
									//DEFENDING PLAYER ROLLS HIS DICE
									//int[] defendingP = players.get(next).rolldice(tr.getnumofarmies());

									//COMPARE RESULTS TO SEE OUTCOME OF THE BATTLE
									//int[] armiesLost = compareDiceRolls(this,attackingP,players.get(next),defendingP);
									
									//update territories after battle
									//this.updateTerritoriesAfterBattle(t,armiesLost[0],tr,armiesLost[1]);
									System.out.println(t.name+" has "+t.getnumofarmies()+" armies left.");
									System.out.println(tr.name+" has "+tr.getnumofarmies()+" armies left.");
									
									//TODO:Prompt user to continue attacking or fortify territory. 
									
									break;
								}
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("You don't have enough armies to attack from this territory.");
						attack(tList,players);
					}
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(this.playerName+", do you want to keep attacking?\n");
	}

	public void defend() {

	}

	public void reinforce() {

	}
}
