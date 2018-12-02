import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * AttackProcess CLASS
 */
public class AttackProcess implements Serializable {
	
	player p; 
	territory[] tList;
	List<player> players;
	deck deck;
	AmazonS3Object s3object = new AmazonS3Object(); //create AmazonS3Object
	
	//////////CONSTRUCTORS//////////////////
	public AttackProcess(player p, territory[] tList, List<player> players, deck deck) {
		this.p = p; 
		this.tList = tList;
		this.players = players;
		this.deck = deck;
	}
	
	////////////METHODS//////////////
	/**
	 * The attack role in the player's turn.
	 */
	public boolean attack() {
		boolean repeat = true;
		/* ------------ WHILE USER WANTS TO KEEP ATTACKING, DO SO ------------ */	
		while(repeat) {
			repeat = Attacking();
		}
		return repeat;
	}

	
	public boolean Attacking(){
		boolean repeat = true;
		System.out.println("FROM which territory would you like to attack? *CHOOSE NUMBER*");
		 /* DISPLAY TERRITORIES USER CAN CHOOSE TO ATTACK FROM */
		this.p.printTerritoriesAndAdjacencies();
		try {
			repeat = attackFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return repeat;
	}
	
	
	public boolean attackFrom() throws IOException{
		String from;
		boolean repeat = true;
		/* READ USER INPUT */
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		from = buffReader();
		int result = Integer.parseInt(from);
		
	/* LOOP THROUGH TERRITORY[]... */
		for(territory t : tList) {
			if(repeat) {
				repeat = attackTerritory(t,result);
			}
		}
	return repeat;
	}
	
	public String buffReader() throws IOException {
		String output = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		output = reader.readLine();
		return output;
	}
	
	
	public boolean attackTerritory(territory t, int result) throws IOException {
		
		boolean repeat = true;
		/* ...AND IF TERRITORY IS OWNED BY THIS PLAYER... */
			if(t.isOwnedBy == this.p.playerNo && t.territoryNumber == result) {
				repeat = attackStepOne(t,repeat,result);
			}
		return repeat;
	}


	public boolean attackStepOne(territory t, boolean repeat, int result) {

		/* SET TERRITORY OWNER TO THIS PLAYER (BECAUSE IT WASN'T DONE EARLIER, I GUESS) */
		t.setOwnerName(this.p.playerName);

		/* ...if territory has at least 2 armies on it.. */
		if(t.numofArmiesHere > 1) {

			System.out.println("Which territory would you like to attack? *CHOOSE NUMBER*");
			int count = 0;

			/* DISPLAY ADJACENT TERRITORIES THAT PLAYER CAN ATTACK (ONLY TERRITORIES THAT
			 * PLAYER DOES NOT OWN).
			 */
			while(count < t.adj_territories.size()) {
				decipherTerritories(t,count);
				count++;
			}

			/* ------------- NOW, READ IN WHICH TERRITORY PLAYER CHOOSES TO ATTACK ------------- */
			//BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
			try {
				String to = buffReader();
				repeat = attackChosenTerritory(to,t,repeat,result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("You don't have enough armies to attack from this territory.");
			attack();
		}
		return repeat;
	}

	
	public boolean decipherTerritories(territory t,int count) {
		boolean output = false;
		/* GET TERRITORY FROM ADJACENT TERRITORIES LIST... */
		territory nameCheck = new territory();
		for(territory n : tList) {
			boolean match = checkTerritoryName(t,n,nameCheck,count);
			if(match) {
				nameCheck = n;
				output = true;
				break;
			}
			//nameCheck = n;
		}
		/* ...AND IF THAT TERRITORY IS *NOT* OWNED BY THIS PLAYER, DISPLAY THE
		 * TERRITORY NUMBER, NAME AND HOW MANY ARMIES THERE FOR THE PLAYER
		 * TO SEE
		 */
		if(this.p.getplayernumber() != nameCheck.isOwnedBy) {
			checkAdjTerr(t,count);
		}
		return output;
	}
	
	public boolean checkAdjTerr(territory t, int count) {
		boolean output = false;
		System.out.printf("%-5s %-23s", "["+t.adj_territories.get(count).territoryNumber+"] ",t.adj_territories.get(count).name );
		System.out.print("(There are ");
		for(territory r : tList) {
			boolean match = printTerritoryArmies(r,t,count);
			if(match) {
				output = true;
				break;
			}
		}
		System.out.println(" armies here.)");
		return output;
	}
	
	public boolean printTerritoryArmies(territory r, territory t, int count) {
		if(r.territoryNumber == t.adj_territories.get(count).territoryNumber) {
			System.out.print(r.numofArmiesHere);
			return true;
		}	
		return false;
	}
	
	public boolean checkTerritoryName(territory t, territory n, territory nameCheck, int count) {
		boolean match;
		if(t.adj_territories.get(count).name.equals(n.name)) {
			nameCheck = n;
			match = true;
			return match;
		}
		match = false;
		return match;
	}
	
	
	public boolean attackChosenTerritory(String to, territory t, boolean repeat, int result) throws IOException{
		
		int result2 = Integer.parseInt(to);

		/* ...LOOP THROUGH TERRITORY[]... */
		for(territory tr : tList) {
			if(repeat) {
				repeat = attackCheck(tr,result,result2,repeat,t);
				//return repeat;
			}
		}
		return repeat;
	}
	
	public boolean attackCheck(territory tr, int result, int result2, boolean repeat,territory t) throws IOException {
		/* ------------ ...AND FOR THE TERRITORY THAT PLAYER CHOOSES TO ATTACK... ------------ */
		//TODO: THROW EXCEPTION IF INPUT IS INVALID & PROMPT FOR ANOTHER CHOICE
		if(tr.territoryNumber == result2 && this.p.playerNo != tr.isOwnedBy) {
			repeat = attackCheck2(tr,result,repeat,t);
		}
		return repeat;
	}
	
	public boolean attackCheck2(territory tr, int result, boolean repeat,territory t) throws IOException {

		/* ------------ SET PLAYER STATUS TO ATTACK ------------ */
		this.p.setAttackMode(true);
		/* ------------ TEMPERARY TERRITORY USED FOR THE ROLLDICE() METHOD NEXT ------------ */
		this.p.notifyDefender(tr.isOwnedBy);
		territory diceTerr = new territory(); 
		diceTerr = tList[result-1]; 
		/* ------------ ARRAY THAT HOLDS THE DICE ROLL RESULT ------------ */
		int[] attackingP = this.p.rolldice(diceTerr.getnumofarmies());
		System.out.println("\n\n***ATTACKING "+tr.name+"!!***\n");
		s3object.writeToFile("game_replay.txt","***ATTACKING "+tr.name+"!!***\n");
		boolean tryagain = true;
		int next = 0;
		/* ------------ SET TERRITORY OWNER TO THIS PLAYER (THIS MAY BE REDUNDANT) ------------ */
		tr.setOwnerName(players.get(next).playerName);

		/* ------------ WHOMEVER OWNS THE DEFENDING TERRITORY, NOTIFY THEM... ------------ */
		while(tryagain) {
			if(tr.isOwnedBy == players.get(next).playerNo) {
				System.out.println(players.get(next).playerName+", you must DEFEND your territory!");
				s3object.writeToFile("game_replay.txt",players.get(next).playerName+", you must DEFEND your territory!\n");
				players.get(next).setDefenseMode(true);
				tryagain = false;
				break; 
			}
			next++;
		}
		/* ------------ ALLOW PLAYER TO DEFEND THEIR TERRITORY ------------*/
		this.p.defend(t,players,tr,next,attackingP,deck);

		/* ------------ PROMPT USER TO CONTINUE ATTACKING OR NOT ------------ */
		System.out.println("Do you want to CONTINUE attacking? *(Y or N)*");
		//BufferedReader keepAttacking = new BufferedReader(new InputStreamReader(System.in));
		try {
			String keepGoing = buffReader();
			repeat = continueAttacking(repeat,keepGoing);
			if(repeat == true) {
				Attacking(); 
			}
			else {
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repeat;
	}
	
	
	public boolean continueAttacking(boolean repeat, String keepGoing) {
			
		/* ------------ IF USER ENTERS "Y" PERFORM ATTACK METHOD AGAIN, IF USER ENETERS "N" THEN END THE ATTACK METHOD ------------ */
		if(keepGoing.equalsIgnoreCase("Y")) {
			repeat = true;
			//Attacking();
		} 
		else if (keepGoing.equalsIgnoreCase("N")){
			repeat = false;
			//return repeat;
		}
		return repeat;
	}

}
