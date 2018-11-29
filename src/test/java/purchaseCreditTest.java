import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

/** 
 * 
 */
public class purchaseCreditTest {
 
	/**
	 * 
	 */
	@Test
	public void purchaseCreditObjectTest(){ 
		player player1 = new player();
		player player2 = new player();
		player player3 = new player();
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		assertEquals(pc.p,player1);
		assertEquals(pc.players,playerList);
	} 
	
	@Test
	public void drawCardWithDesignTest() {
		card testCard = new card('a',"territory");
		player player1 = new player();
		player player2 = new player();
		player player3 = new player();
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		pc.drawCardWithDesign(testCard);
		assertEquals(pc.p.hand.get(0).territory,"*ANY Territory*");
		assertEquals(pc.p.hand.get(0).design,'a');
	}
	
	@Test
	public void printCreditOptionsTest() {
		player player1 = new player();
		player player2 = new player();
		player player3 = new player();
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		String test = pc.printCreditOptions();
		assertEquals(test,"\nC - exchange for card\nU - exchange for Undo\nT - transfer credits to another player\n");
	}
	
	@Test
	public void printCardOptionsTest() {
		player player1 = new player();
		player player2 = new player();
		player player3 = new player();
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		String test = pc.printCardOptions();
		assertEquals(test,"\nI - Infantry card\nA - Artillary card\nC - Calvary card\n");
	}

	@Test
	public void printPlayersTest() {
		player player1 = new player();
		player1.playerName = "one";
		player player2 = new player();
		player2.playerName = "two";
		player player3 = new player();
		player3.playerName = "three";
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1); 
		playerList.add(player2);
		playerList.add(player3); 
		List<String> playerNames = new ArrayList<String>();
		playerNames.add(playerList.get(0).playerName);
		playerNames.add(playerList.get(1).playerName);
		playerNames.add(playerList.get(2).playerName);
		Risk_Game rG = new Risk_Game();
		rG.playersN = playerNames; 
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		String test = pc.printPlayers();
		assertEquals(test,"one two three "); 
	}
	
	@Test
	public void beginTest() throws IOException{ 
		player player1 = new player();
		player player2 = new player();
		player player3 = new player();
		List<player> playerList = new ArrayList<player>();
		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		purchaseCredit pc = new purchaseCredit(player1,playerList);
		assertEquals(pc.begin(),"no");
	} 
}
