import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.Test;

/** 
 * 
 */
public class AttackProcessTest {
 
	/**
	 * @throws IOException 
	 * 
	 */
	@Test
	public void continueAttackingYTest() throws IOException{ 
		player p = new player();
		territory[] tList = new territory[1];
		List<player> players = new ArrayList<player>(); 
		deck deck = new deck(42);
		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
		boolean repeat = false; 
		assertEquals(attackTest.continueAttacking(repeat,"Y"),true);
	} 
	
	/**
	 * @throws IOException 
	 * 
	 */
	@Test
	public void continueAttackingNTest() throws IOException{ 
		player p = new player();
		territory[] tList = new territory[1];
		List<player> players = new ArrayList<player>(); 
		deck deck = new deck(42);
		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
		boolean repeat = false; 
		assertEquals(attackTest.continueAttacking(repeat,"N"),false);
	} 
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void attackCheck2Test() throws Exception{ 
		player p = new player(); 
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
//		player p3 = new player();
//		p3.playerNo = 3;
//		p3.playerName = "testPlayer3";
		territory tr = new territory();
		tr.isOwnedBy = 1;
		int result = 2; 
		boolean repeat = false;
		territory t = new territory();
		
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2); 
		//players.add(p3);
		deck deck = new deck(42);
		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
		assertEquals(attackTest.attackCheck2(tr,result,repeat,t),false);
	} 
	
	

}
