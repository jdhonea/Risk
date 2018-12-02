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
		p2.playerNo = 1;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 1;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42);
		boolean repeat = false;
		territory tr = tList[1];
		territory t = tList[1];
		tr.isOwnedBy = 1;
		tr.territoryNumber = 1;
		tr.numofArmiesHere = 3;
		players.get(0).chooseTerritory(tr);
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		attackTest.players = players;
		assertEquals(attackTest.attackCheck2(tr,1,repeat,t),false);
	} 

	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void attackCheckTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 

		territory tr = new territory();
		tr.territoryNumber = 5;
		tr.isOwnedBy = 1;
		int result = 0; 
		int result2 = 5;
		boolean repeat = true;
		territory t = new territory();
		
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.attackCheck(tr,result,result2,repeat,t),true);
	}	
	
//	/**
//	 * @throws Exception 
//	 * 
//	 */
//	@Test
//	public void attackChosenTerritoryTest() throws Exception{ 
//		player p = new player();
//		p.playerNo = 1;
//		p.playerName = "testPlayer";
//		player p2 = new player();
//		p2.playerNo = 1;
//		p2.playerName = "testPlayer2";
//		player p3 = new player();
//		p3.playerNo = 1;
//		p3.playerName = "testPlayer3";
//		territory[] tList = new territory[42];
//		Risk_Game.initializeTerritories(tList);
//		List<player> players = new ArrayList<player>();
//		players.add(p);
//		players.add(p2);
//		players.add(p3);
//		deck deck = new deck(42); 
//
//		territory tr = new territory();
//		tr.territoryNumber = 5;
//		tr.isOwnedBy = 1;
//		String to;
//		int result = 0; 
//		int result2 = 5;
//		boolean repeat = true;
//		territory t = new territory();
//		
//		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
//		attackTest.players = players;
//		assertEquals(attackTest.attackChosenTerritory("1",tr,repeat,2),true);
//	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void checkTerritoryNameMatchTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		territory nameCheck = new territory(); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.checkTerritoryName(tList[19],tList[13],nameCheck,count),true);
	}

	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void checkTerritoryNameTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		territory nameCheck = new territory(); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.checkTerritoryName(tList[19],tList[14],nameCheck,count),false);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void printTerritoryArmies1Test() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.printTerritoryArmies(tList[13],tList[19],count),true);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void printTerritoryArmies2Test() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.printTerritoryArmies(tList[13],tList[18],count),false);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void checkAdjTerrTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.checkAdjTerr(tList[19],count),true);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void decipherTerritoriesTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		assertEquals(attackTest.decipherTerritories(tList[19],count),true);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void attackTerritoryTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42); 
		int count = 0; 
		AttackProcess attackTest = new AttackProcess(players.get(0), tList, players, deck);	
		tList[19].isOwnedBy = 1;
		attackTest.p.chooseTerritory(tList[19]);
		tList[19].numofArmiesHere = 5;
		assertEquals(attackTest.attackTerritory(tList[19],19),true);
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void attackFromTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42);
		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
		assertEquals(attackTest.attackFrom(),true);
	} 
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void AttackingTest() throws Exception{ 
		player p = new player();
		p.playerNo = 1;
		p.playerName = "testPlayer";
		player p2 = new player();
		p2.playerNo = 2;
		p2.playerName = "testPlayer2";
		player p3 = new player();
		p3.playerNo = 3;
		p3.playerName = "testPlayer3";
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		List<player> players = new ArrayList<player>();
		players.add(p);
		players.add(p2);
		players.add(p3);
		deck deck = new deck(42);
		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
		assertEquals(attackTest.Attacking(),true);
	} 
	
//	/**
//	 * @throws Exception 
//	 * 
//	 */
//	@Test
//	public void attackTest() throws Exception{ 
//		player p = new player();
//		p.playerNo = 1;
//		p.playerName = "testPlayer";
//		player p2 = new player();
//		p2.playerNo = 2;
//		p2.playerName = "testPlayer2";
//		player p3 = new player();
//		p3.playerNo = 3;
//		p3.playerName = "testPlayer3";
//		territory[] tList = new territory[42];
//		Risk_Game.initializeTerritories(tList);
//		List<player> players = new ArrayList<player>();
//		players.add(p);
//		players.add(p2);
//		players.add(p3);
//		deck deck = new deck(42);
//		AttackProcess attackTest = new AttackProcess(p, tList, players, deck);
//		tList[19].isOwnedBy = 1;
//		attackTest.p.chooseTerritory(tList[19]);
//		tList[19].numofArmiesHere = 5;
//		assertEquals(attackTest.attack(),true);
//	} 
	
}
