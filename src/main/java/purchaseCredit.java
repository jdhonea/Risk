import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * PURCHASE CREDIT CLASS
 */	
public class purchaseCredit implements Serializable{

	String credit = "";
	int amount = 0;
	String useCredits = "";
	String answer = "";
	player p = new player();
	List<player> players = new ArrayList<player>();
	
	public purchaseCredit(player thisPlayer,List<player> players) {
		this.p = thisPlayer;
		this.players = players;
	}

	/**
	 * Begin process of credit use
	 */	
	public void begin() throws IOException {
		System.out.println("\n"+p.getPlayerName()+", would you like to purchase credit? (Y or N)");
		this.creditReader();
		System.out.println("\nwould you like to use credits now? (*Y or N)");
		this.useCredits();
	}
	
	/**
	 * Player purchases credit
	 */	
	public void creditReader() {
		BufferedReader creditreader = new BufferedReader(new InputStreamReader(System.in));
		try {
			credit = creditreader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(credit.equalsIgnoreCase("Y")) {
			System.out.println("\nHow many credits would you like to purchase? (ENTER NUMBER)");
			BufferedReader creditreader2 = new BufferedReader(new InputStreamReader(System.in));
			try {
				amount = Integer.parseInt(creditreader2.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}
			p.credits.setCreditValue(amount);
		}
	}
	
	/**
	 * Begin credit process
	 * Prompts user to choose an option for credit use
	 */	
	public void useCredits() throws IOException {
		BufferedReader creditreader3 = new BufferedReader(new InputStreamReader(System.in));
		try {
			useCredits = creditreader3.readLine();
			if(useCredits.equalsIgnoreCase("Y")) {
				System.out.println("\nWhich would you like to do? (ENTER LETTER)");
				String options = this.printCreditOptions();
				System.out.print(options);
				this.chooseCredit();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads user input choice for credit use
	 */	
	public void chooseCredit() {
		BufferedReader creditreader4 = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = creditreader4.readLine();
			if(answer.equalsIgnoreCase("C")) {
				// exchange for card
				System.out.println("\nWhich type of card would you like? (ENTER LETTER)");
				String cards = printCardOptions();
				System.out.print(cards);
				this.creditSwitch();
			}
			if(answer.equalsIgnoreCase("U")) {
				//exchange for undo
				int undos = p.credits.exchangeForUndo();
				p.undoActions = undos;
			}
			if(answer.equalsIgnoreCase("T")) {
				// transfer to another player
				System.out.println("\nTransfer to WHOM? (ENTER *NAME)");
				String tradeWithWhom = printPlayers();
				System.out.print(tradeWithWhom);
				this.transferCreditSwitch();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Allows current player to transfer credit to specified player
	 */	
	public void transferCreditSwitch() throws IOException {
		boolean good = true;
		String answer;
		BufferedReader creditreader5 = new BufferedReader(new InputStreamReader(System.in));
		while(good) {
				answer = creditreader5.readLine();
				if(answer.equalsIgnoreCase(players.get(0).playerName)) {
					p.credits.transferCredits(p, players.get(0), p.credits.creditValue);
					good = false;
				}
				else if(answer.equalsIgnoreCase(players.get(1).playerName)) {
					p.credits.transferCredits(p, players.get(1), p.credits.creditValue);
					good = false;
				}
				else if(answer.equalsIgnoreCase(players.get(2).playerName)) {
					p.credits.transferCredits(p, players.get(2), p.credits.creditValue);
					good = false;
				}
				else if(answer.equalsIgnoreCase(players.get(3).playerName)) {
					p.credits.transferCredits(p, players.get(3), p.credits.creditValue);
					good = false;
				}
				else if(answer.equalsIgnoreCase(players.get(4).playerName)) {
					p.credits.transferCredits(p, players.get(4), p.credits.creditValue);
					good = false;
				}
				else if(answer.equalsIgnoreCase(players.get(5).playerName)) {
					p.credits.transferCredits(p, players.get(5), p.credits.creditValue);
					good = false;
				}
		}
	}
	
	/**
	 * Allows player to purchase specific type of card
	 */	
	public void creditSwitch() {
		String answer2;
		card chosen;
		BufferedReader creditreader5 = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer2 = creditreader5.readLine();
			if(answer2.equalsIgnoreCase("I")) {
				chosen = p.credits.exchangeForCard('i', "");
				drawCardWithDesign(chosen);
			}
			if(answer2.equalsIgnoreCase("A")) {
				chosen = p.credits.exchangeForCard('a', "");
				drawCardWithDesign(chosen);
			}
			if(answer2.equalsIgnoreCase("C")) {
				chosen = p.credits.exchangeForCard('c', "");
				drawCardWithDesign(chosen);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Player draws specific card from deck
	 */	
	public void drawCardWithDesign(card chosen) {
		chosen.territory = "*ANY Territory*";
			p.hand.add(chosen);

	}
	
	/**
	 * Print out options for credit use
	 */	
	public String printCreditOptions() {
		String output = "\nC - exchange for card\nU - exchange for Undo\nT - transfer credits to another player\n";
		return output;
	}
	
	/**
	 * Display card options for credit use
	 */	
	public String printCardOptions() {
		String output = "\nI - Infantry card\nA - Artillary card\nC - Calvary card\n";
		return output;
	}
	
	/**
	 * Display other Player names so current player can choose which player to transfer credit to
	 */	
	public String printPlayers() {
		String output = "";
		for(String s : Risk_Game.playersN) {
			output += s + " ";
		}
		return output;
	}
	
}
