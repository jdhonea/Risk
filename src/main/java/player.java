//package com.risktakers.Risk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
	boolean cardAlreadyPicked = false;
	
	boolean conquered = false; //variable to check & see if player can pull a card
	
	String[][] playerOptions = new String[3][2];
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
		return this.territoriesOwned.size();
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
	//Displays the players current hand of cards
	public void printHand(){
		for(int n = 0; n < hand.size(); n++){
			System.out.println(n+1 + "\t" + hand.get(n).getDesign() + "\t" + hand.get(n).getTerritory());
		}
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

	public void printTerritories(){
		System.out.println("\n"+playerName+" owns: ");
		for(int x = 0; x < territoriesOwned.size(); x++) {
			System.out.printf("%-5s","[" + territoriesOwned.get(x).territoryNumber + "] ");
			System.out.println(territoriesOwned.get(x).name+" (has "+territoriesOwned.get(x).getnumofarmies()+" armies.)");

		}
	}

	//PRINT TERRITORIES AND ADJACENT TERRITORIES THAT THE PLAYER OWNS
	public void printTerritoriesAndAdjacencies() {
		System.out.println("\n"+playerName+" owns: ");
		for(int x = 0; x < territoriesOwned.size(); x++) {
			System.out.printf("%-5s %-40s","[" + territoriesOwned.get(x).territoryNumber + "] ", territoriesOwned.get(x).name+" (has "+territoriesOwned.get(x).getnumofarmies()+" armies.)");
			System.out.print("------>  Adjacent territories: [");
			for(territory t : territoriesOwned.get(x).adj_territories) {
				System.out.print(" "+t.name+",");
			}
			System.out.println("]");
		}
	}

	//PRINT TERRITORIES AND ADJACENT TERRITORIES THAT THE PLAYER OWNS
	public void printTerritoriesOwned() {
		System.out.println("\n"+playerName+" owns: ");
		for(int x = 0; x < territoriesOwned.size(); x++) {
			System.out.println("[" + territoriesOwned.get(x).territoryNumber + "]\t"+ territoriesOwned.get(x).name+" (has "+territoriesOwned.get(x).getnumofarmies()+" armies.)");
		}
	}

		public void endturn() {
		/**
		 * If player decides to end turn
		 */
		System.out.println(this.playerName+"'s turn is over. NEXT PLAYER...\n");
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

	//Player draws top card of deck
		public void drawCard(deck deck) {
			hand.add(deck.drawCard());
		}
	
	/**
	 * Updating number of armies on each territory after battle
	 * 
	 */
	public void updateTerritoriesAfterBattle(territory attackingFrom, int attackerLost, territory defendingFrom, int defenderLost, int advanceNum, deck deck) {
		attackingFrom.setnumberofarmies(attackingFrom.getnumofarmies()-attackerLost);
		defendingFrom.setnumberofarmies(defendingFrom.getnumofarmies()-defenderLost);
		
		//TODO: FIGURE OUT HOW TO SWITCH OWNERSHIP OF TERRITORY WHEN NEEDED
		if(defendingFrom.getnumofarmies() < 1) {
			conquered = true;
			defendingFrom.setOwner(attackingFrom.isOwnedBy);
			defendingFrom.setOwnerName(attackingFrom.ownerName);
			System.out.println("\n***"+defendingFrom.name+" has been conquered by "+attackingFrom.ownerName+"!!**\n");
			this.advance(attackingFrom,defendingFrom,advanceNum);
			this.territoriesOwned.add(defendingFrom);
			if(cardAlreadyPicked == false) {
				cardAlreadyPicked = true;
				//TODO: PLAYER DRAWS A CARD HERE!!!
				this.drawCard(deck);
				System.out.println("***DRAWING CARD FROM DECK***\n"+this.playerName+" drew the "+this.hand.get(this.hand.size()-1).getCardType()+" card.");
				System.out.print("You now have cards: [");
				for(card c : this.hand) {
					System.out.print(" "+ c.getCardType()+", ");
				}
				System.out.println("]\n");
			}
		}
	}
	
	/**
	 * Comparing dice rolls to determine outcome of battle
	 * RETURNS INT[] CONTAINING NUMBER OF ARMIES LOST FOR EACH PLAYER'S TERRITORY
	 * RETURN int[] outcome[numberOfArmiesLostByAttacker, numberOfArmiesLostByDefender]
	 */
	public int[] compareDiceRolls(player p1,int[] p1Dice,player p2,int[] p2Dice) {
		int[] outcome = new int[3];
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
		outcome[2] = p1Dice.length;
		return outcome;

	}

		/**
	 * ATTACK METHOD
	 */
	public void attack(territory[] tList, List<player> players,deck deck) {

/* ------------ METHOD VARIABLES ------------ */		
		String from;
		String keepGoing = "";
		boolean repeat = true;

/* ------------ WHILE USER WANTS TO KEEP ATTACKING, DO SO ------------ */		
		while(repeat) {
			System.out.println("FROM which territory would you like to attack? *CHOOSE NUMBER*");
			 /* DISPLAY TERRITORIES USER CAN CHOOSE TO ATTACK FROM */
			this.printTerritoriesAndAdjacencies();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				/* READ USER INPUT */
				from = reader.readLine();
				int result = Integer.parseInt(from);
				
			/* LOOP THROUGH TERRITORY[]... */
				for(territory t : tList) {
					
				/* ...AND IF TERRITORY IS OWNED BY THIS PLAYER... */
					if(t.isOwnedBy == this.playerNo && t.territoryNumber == result) {
						/* SET TERRITORY OWNER TO THIS PLAYER (BECAUSE IT WASN'T DONE EARLIER, I GUESS) */
						t.setOwnerName(this.playerName);
						
					/* ...if territory has at least 2 armies on it.. */
						if(t.numofArmiesHere > 1) {
							String to;
							System.out.println("Which territory would you like to attack? *CHOOSE NUMBER*");
							int count = 0;
						
						/* DISPLAY ADJACENT TERRITORIES THAT PLAYER CAN ATTACK (ONLY TERRITORIES THAT
						 * PLAYER DOES NOT OWN).
						 */
							while(count < t.adj_territories.size()) {
								
								/* GET TERRITORY FROM ADJACENT TERRITORIES LIST... */
								territory nameCheck = new territory();
								for(territory n : tList) {
									if(t.adj_territories.get(count).name.equals(n.name)) {
										nameCheck = n;
										break;
									}
								}
						/* ...AND IF THAT TERRITORY IS *NOT* OWNED BY THIS PLAYER, DISPLAY THE
						* TERRITORY NUMBER, NAME AND HOW MANY ARMIES THERE FOR THE PLAYER
						* TO SEE
						*/
								if(this.getplayernumber() != nameCheck.isOwnedBy) {
									System.out.printf("%-5s %-23s", "["+t.adj_territories.get(count).territoryNumber+"] ",t.adj_territories.get(count).name );
									System.out.print("(There are ");

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
						/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
							
							
		/* ------------- NOW, READ IN WHICH TERRITORY PLAYER CHOOSES TO ATTACK ------------- */
							BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
							try {
								to = reader2.readLine();
								int result2 = Integer.parseInt(to);	
								
					/* ...LOOP THROUGH TERRITORY[]... */
								for(territory tr : tList) {
									
				/* ------------ ...AND FOR THE TERRITORY THAT PLAYER CHOOSES TO ATTACK... ------------ */
							//TODO: THROW EXCEPTION IF INPUT IS INVALID & PROMPT FOR ANOTHER CHOICE
									if(tr.territoryNumber == result2 && this.playerNo != tr.isOwnedBy) {
						/* ------------ SET PLAYER STATUS TO ATTACK ------------ */
										this.setAttackMode(true);
						/* ------------ TEMPERARY TERRITORY USED FOR THE ROLLDICE() METHOD NEXT ------------ */
										territory diceTerr = new territory();
										diceTerr = tList[result-1];
						/* ------------ ARRAY THAT HOLDS THE DICE ROLL RESULT ------------ */
										int[] attackingP = this.rolldice(diceTerr.getnumofarmies());
										System.out.println("\n\n***ATTACKING "+tr.name+"!!***\n");
										
										boolean tryagain = true;
										int next = 0;
						/* ------------ SET TERRITORY OWNER TO THIS PLAYER (THIS MAY BE REDUNDANT) ------------ */
										tr.setOwnerName(players.get(next).playerName);

						/* ------------ WHOMEVER OWNS THE DEFENDING TERRITORY, NOTIFY THEM... ------------ */
										while(tryagain) {
											if(tr.isOwnedBy == players.get(next).playerNo) {
												System.out.println(players.get(next).playerName+", you must DEFEND your territory!");
												players.get(next).setDefenseMode(true);
												tryagain = false;
												break;
											}
											next++;
										}
						/* ------------ ALLOW PLAYER TO DEFEND THEIR TERRITORY ------------*/
										defend(t,players,tr,next,attackingP,deck);
										
/* ------------ PROMPT USER TO CONTINUE ATTACKING OR NOT ------------ */
										System.out.println("Do you want to CONTINUE attacking? *(Y or N)*");
										BufferedReader keepAttacking = new BufferedReader(new InputStreamReader(System.in));
										try {
											keepGoing = keepAttacking.readLine();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
/* ------------ IF USER ENTERS "Y" PERFORM ATTACK METHOD AGAIN, IF USER ENETERS "N" THEN END THE ATTACK METHOD ------------ */
										if(keepGoing.equalsIgnoreCase("Y")) {
											repeat = true;
										} 
										else if (keepGoing.equalsIgnoreCase("N")){
											repeat = false;
											break;
										}
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	
										
									}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println("You don't have enough armies to attack from this territory.");
							attack(tList,players,deck);
						}
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//ADVANCE TROOPS AFTER CONQUERING A TERRITORY
	public void advance(territory t1,territory t, int advanceNum) {
		String input = "";
		int advance = 0;
			System.out.println(t.ownerName+", how many armies do you want to move into "+t.name+"?\n****You may move up to "+advanceNum+" armies here.****");
			//Enter data using BufferReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Reading data using readLine
			try {
				input = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			advance = Integer.parseInt(input);
			t.addTokensToTerritory(advance);
			t1.numofArmiesHere = t1.numofArmiesHere - advance;
	}
	
	public void defend(territory t, List<player> players, territory tr, int next, int[] attackingP,deck deck) {
		int[] defendingP = players.get(next).rolldice(tr.getnumofarmies());

		//COMPARE RESULTS TO SEE OUTCOME OF THE BATTLE
		int[] armiesLost = compareDiceRolls(this,attackingP,players.get(next),defendingP);

		//update territories after battle
		updateTerritoriesAfterBattle(t,armiesLost[0],tr,armiesLost[1],armiesLost[2],deck);
		System.out.println(t.name+" now has "+t.getnumofarmies()+" armies.");
		System.out.println(tr.name+" now has "+tr.getnumofarmies()+" armies.");
	}

	/*public void reinforce(int numOfArmies) {
		System.out.println("\n"+this.getPlayerName()+", let's REINFORCE your territories!\n");
		//TODO; COMPLETE THIS!!!
	}*/

		private int readInputToInt() {
		String input = "";
		int advance = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		advance = Integer.parseInt(input);
		return advance;
	}
	
	private String getTerritoriesToFortifyFrom(int advance) {
		String output = "";
		/* -------- LOOP THROUGH OWNED TERRITORIES LIST... -------- */
		for(territory t : this.territoriesOwned) {
/* -------- ...AND IF TERRITORY NUMBER MATCHES THE NUMBER THE PLAYER CHOSE... -------- */
			if(t.territoryNumber == advance) {
	/* -------- ...FOR EACH ADJACENT TERRITORY *THAT THE PLAYER OWNS*... -------- */
				for(territory aT : t.adj_territories) {
					for(territory nT : this.territoriesOwned) {
		/* -------- ...ADD IT TO THE OUTPUT STRING. -------- */
						if(nT.name.equalsIgnoreCase(aT.name)) {
							output = "[" + aT.territoryNumber + "] "+ aT.name + " (has "+ nT.numofArmiesHere +" armies.)";
						}
					}
				}
			}
		}
		return output;
	}
	
	public void fortify(territory[] tList) {
		
	/* method variables */
		int advance = 0;
		int advance2 = 0;
		int numOfTroops = 0;
		String output = "";
		
		boolean keep = true;
		System.out.println("\n"+this.getPlayerName()+", let's FORTIFY a territory!");
		while(keep) {
			this.printTerritoriesOwned();
			System.out.println("\nWhich territory would you like to fortify? **CHOOSE NUMBER**");
			advance = readInputToInt();

			output = getTerritoriesToFortifyFrom(advance);
			
/* -------- IF OUTPUT IS EMPTY, THEN THERE ARE NO ADJACENT TERRITORIES THAT PLAYER CAN MOVE ARMIES FROM -------- */
			if(output == "") {
				System.out.println("You cannot fortify this position! **TRY AGAIN**");
				keep = true;
			} else {
/* -------- DISPLAY TERRITORIES FOR PLAYER TO CHOSE FROM -------- */				
				System.out.println(output);
				keep = false;
			}
		}
		System.out.println("FROM which territory would you like to move your troops? **CHOOSE NUMBER**");
		advance2 = readInputToInt();
		
/* -------- DISPLAY STATUS OF TERRITORY THAT PLAYER CHOSE -------- */
		System.out.println("**"+tList[advance2-1].name+" has "+tList[advance2-1].numofArmiesHere+" armies here.**");
		
		System.out.println("How many armies would you like to move?");
		numOfTroops = readInputToInt();
		
/* -------- ADJUST NUMBER OF ARMIES IN EACH TERRITORY, AFTER FORTIFICATION -------- */
		tList[advance2-1].numofArmiesHere = tList[advance2-1].numofArmiesHere - numOfTroops;
		tList[advance-1].numofArmiesHere = tList[advance-1].numofArmiesHere + numOfTroops;

/* -------- DISPLAY STATUS OF TERRITORIES AFTER FORTIFICATION -------- */
		System.out.println("***"+this.playerName+" has FORTIFIED "+tList[advance-1].name+"***");
		System.out.println(tList[advance2-1].name+" now has "+tList[advance2-1].numofArmiesHere+" armies and "+tList[advance-1].name+" has "+tList[advance-1].numofArmiesHere+" armies.\n");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/* ------------------------------------------------------------------- */
		
	}
}
