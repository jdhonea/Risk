import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

//import static org.junit.Assert.*;

//import org.junit.Test;

/** 
 * 
 */
public class playerTest {

	/**
	 * setnumofterritory Tests
	 */
	@Test
	public void setnumofterritoriesFortyThreeTest(){
		player p = new player();
		p.setnumofterritories(43);
		assertEquals(0, p.terrOwned);
	}
	@Test
	public void setnumofterritoriesNegativeTest(){
		player a = new player();
		a.setnumofterritories(-1);
		assertEquals(0, a.terrOwned);
	}
	@Test
	public void setnumofterritoriesTwentyTest(){
		player p = new player();
		p.setnumofterritories(20);
		assertEquals(20, p.terrOwned);
	}
	@Test
	public void setnumofterritoriesFortyTwoTest(){
		player p = new player();
		p.setnumofterritories(42);
		assertEquals(42, p.terrOwned);
	}
	@Test
	public void setnumofterritoriesZeroTest(){
		player p = new player();
		p.setnumofterritories(0);
		assertEquals(0, p.terrOwned);
	}
	
	////////////////////////////////////////////////////
	
	/**
	 * setnumofdicerolls Tests
	 */
	@Test
	public void setnumofdicerollszeroTest(){
		player p = new player();
		p.setnumofdicerolls(0);
		assertEquals(0, p.numOfDiceRolls);
	}
	
	@Test
	public void setnumofdicerollsfourTest(){
		player p = new player();
		p.setnumofdicerolls(4);
		assertEquals(0, p.numOfDiceRolls);
	}
	
	@Test
	public void setnumofdicerollsnegativeTest(){
		player p = new player();
		p.setnumofdicerolls(-1);
		assertEquals(0, p.numOfDiceRolls);
	}
	
	@Test
	public void setnumofdicerollsTest(){
		player p = new player();
		p.setnumofdicerolls(2);
		assertEquals(2, p.numOfDiceRolls);
	}
	
	///////////////////////////////////////////////////
	
	/**
	 * setCanTrade Tests
	 */
	@Test
	public void setCanTradeTrueTest(){
		player p = new player();
		p.setCanTrade(true);
		assertEquals(true, p.canTrade);
	}
	
	@Test
	public void setCanTradeFalseTest(){
		player p = new player();
		p.setCanTrade(false);
		assertEquals(false, p.canTrade);
	}

	@Test
	public void playerTooManyTest() throws IOException{
		int num = 7;
		player testPlayer = new player(num);
		assertEquals(testPlayer.playerNo,0);
	}
	
	@Test
	public void playerTooFewTest() throws IOException{
		int num = 1;
		player testPlayer = new player(num);
		assertEquals(testPlayer.playerNo,0);
	}
	
	@Test
	public void addPlayerNameToListTest() {
		String testName = "testName";
		String testOutput = null;
		List<String> playersN = new ArrayList<String>();
		playersN.add("testName");
		testOutput = playersN.get(0);
		assertEquals(testName,testOutput);
	}
	
	@Test
	public void setBoardTest(){
		board testBoard = new board();
		player testPlayer = new player();
		testPlayer.setBoard(testBoard);
		assertEquals(testPlayer.board,testBoard);
	}
	
	@Test
	public void getPlayerNumberTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 5;
		assertEquals(testPlayer.getplayernumber(),5);
	}
	
	@Test
	public void reduceUnplacedArmiesTest() {
		player testPlayer = new player();
		testPlayer.unplacedArmies = 10;
		testPlayer.reduceUnplacedArmies();
		assertEquals(testPlayer.unplacedArmies,9);
	}
	/////////////////////////////////////
	@Test
	public void getUnplacedArmiesTest() {
		player testPlayer = new player();
		testPlayer.unplacedArmies = 10;
		assertEquals(testPlayer.getUnplacedArmies(),10);
	}

	@Test
	public void getPlayerNameTest() {
		player testPlayer = new player();
		testPlayer.playerName = "Derrick";
		assertEquals(testPlayer.getPlayerName(),"Derrick");
	}
	
	@Test
	public void setNumberofArmiesTest() {
		player testPlayer = new player();
		testPlayer.setnumofarmies(10);
		assertEquals(testPlayer.getnumofarmies(),10);
	}
	
	@Test
	public void getNumberofArmiesTest() {
		player testPlayer = new player();
		testPlayer.numOfArmies = 10;
		assertEquals(testPlayer.getnumofarmies(),10);
	}
	
	@Test
	public void setNumberofCardsTest() {
		player testPlayer = new player();
		testPlayer.setnumofcards(3);
		assertEquals(testPlayer.getnumofcards(),3);
	}
	
	@Test
	public void getNumberofCardsTest() {
		player testPlayer = new player();
		testPlayer.numOfCards = 3;
		assertEquals(testPlayer.getnumofcards(),3);
	}
	///////////////////////////////////////////
	@Test
	public void getNumberofTerritoriesTest() {
		player testPlayer = new player();
		assertEquals(testPlayer.getnumofterritories(),0);
	}
	
	@Test
	public void getNumberofDiceRollsTest() {
		player testPlayer = new player();
		testPlayer.numOfDiceRolls = 3;
		assertEquals(testPlayer.getnumofdicerolls(),3);
	}
	
	@Test
	public void resetCardsContainedOwnedTerritoryTest() {
		player testPlayer = new player();
		testPlayer.cardsContainedOwnedTerritory = true;
		testPlayer.resetCardsContainedOwnedTerritory();
		assertEquals(testPlayer.cardsContainedOwnedTerritory,false);
	}
////////////////////////////////////
	@Test
	public void canTradeTest() {
		player testPlayer = new player();
		testPlayer.canTrade = true;
		assertEquals(testPlayer.canTrade(),true);
	}

	@Test
	public void setWinnerTrueTest() {
		player testPlayer = new player();
		testPlayer.setWinner(true);
		assertEquals(testPlayer.wonWholeGame,true);
	}
	@Test
	public void setWinnerFalseTest() {
		player testPlayer = new player();
		testPlayer.setWinner(false);
		assertEquals(testPlayer.wonWholeGame,false);
	}

	@Test
	public void getWinnerTest() {
		player testPlayer = new player();
		testPlayer.setWinner(false);
		assertEquals(testPlayer.getWinner(),false);
	}

	@Test
	public void setwinnerofbattleTrueTest() {
		player testPlayer = new player();
		testPlayer.setwinnerofbattle(true);
		assertEquals(testPlayer.win,true);
	}
	
	@Test
	public void setwinnerofbattleFalseTest() {
		player testPlayer = new player();
		testPlayer.setwinnerofbattle(false);
		assertEquals(testPlayer.win,false);
	}

	@Test
	public void getwinnerofbattleTest() {
		player testPlayer = new player();
		testPlayer.setwinnerofbattle(false);
		assertEquals(testPlayer.getwinnerofbattle(),false);
	}

	@Test
	public void setloserofbattleTrueTest() {
		player testPlayer = new player();
		testPlayer.setloserofbattle(true);
		assertEquals(testPlayer.lose,true);
	}
	
	@Test
	public void setloserofbattleFalseTest() {
		player testPlayer = new player();
		testPlayer.setloserofbattle(false);
		assertEquals(testPlayer.lose,false);
	}

	@Test
	public void getloserofbattleTest() {
		player testPlayer = new player();
		testPlayer.setloserofbattle(false);
		assertEquals(testPlayer.getloserofbattle(),false);
	}
	
	@Test
	public void ownthisterritoryYesTest() {
		territory testTerritory = new territory();
		testTerritory.isOwnedBy = 1;
		player testPlayer = new player();
		testPlayer.playerNo = 1;
		assertEquals(testPlayer.ownthisterritory(testTerritory),true);
	}
	
	@Test
	public void ownthisterritoryNoTest() {
		territory testTerritory = new territory();
		testTerritory.isOwnedBy = 1;
		player testPlayer = new player();
		testPlayer.playerNo = 3;
		assertEquals(testPlayer.ownthisterritory(testTerritory),false);
	}

	@Test
	public void canAttackTrueTest() {
		territory testTerritory = new territory();
		testTerritory.isOwnedBy = 1;
		player testPlayer = new player();
		testPlayer.playerNo = 3;
		testPlayer.canAttack(testTerritory);
		assertEquals(testPlayer.canAttack,true);
	}
	
	@Test
	public void canAttackFalseTest() {
		territory testTerritory = new territory();
		testTerritory.isOwnedBy = 3;
		player testPlayer = new player();
		testPlayer.playerNo = 3;
		testPlayer.canAttack(testTerritory);
		assertEquals(testPlayer.canAttack,false);
	}

	@Test
	public void setAttackModeTest1() {
		player testPlayer = new player();
		testPlayer.setAttackMode(true);
		assertEquals(testPlayer.isAttacking,true);
		assertEquals(testPlayer.isDefending,false);
	}
	
	@Test
	public void setAttackModeTest2() {
		player testPlayer = new player();
		testPlayer.setAttackMode(false);
		assertEquals(testPlayer.isAttacking,false);
		assertEquals(testPlayer.isDefending,true);
	}
	
	@Test
	public void isAttackingTest1() {
		player testPlayer = new player();
		testPlayer.setAttackMode(false);
		assertEquals(testPlayer.isAttacking(),false);
	}
	
	@Test
	public void isAttackingTest2() {
		player testPlayer = new player();
		testPlayer.setAttackMode(true);
		assertEquals(testPlayer.isAttacking(),true);
	}

	
	
	@Test
	public void setDefenseModeTest1() {
		player testPlayer = new player();
		testPlayer.setDefenseMode(true);
		assertEquals(testPlayer.isAttacking,false);
		assertEquals(testPlayer.isDefending,true);
	}
	
	@Test
	public void setDefenseModeTest2() {
		player testPlayer = new player();
		testPlayer.setDefenseMode(false);
		assertEquals(testPlayer.isAttacking,true);
		assertEquals(testPlayer.isDefending,false);
	}
	
	@Test
	public void isDefendingTest1() {
		player testPlayer = new player();
		testPlayer.setDefenseMode(false);
		assertEquals(testPlayer.isDefending(),false);
	}
	
	@Test
	public void isDefendingTest2() {
		player testPlayer = new player();
		testPlayer.setDefenseMode(true);
		assertEquals(testPlayer.isDefending(),true);
	}

	@Test
	public void continueAttackingTest() {
		player testPlayer = new player();
		testPlayer.isAttacking = false;
		testPlayer.continueAttacking();
		assertEquals(testPlayer.isAttacking,true);
	}

	@Test
	public void addTokenToTerritoryTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 5;
		territory testTerritory = new territory();
		testTerritory.numofArmiesHere = 0;
		testPlayer.addTokenToTerritory(testTerritory);
		assertEquals(testTerritory.numofArmiesHere,1);
		assertEquals(testTerritory.isOwnedBy,5);
		assertEquals(testTerritory.isTaken,true);
	}

	@Test
	public void addTokensToTerritoryTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 5;
		territory testTerritory = new territory();
		testTerritory.numofArmiesHere = 2;
		testPlayer.addTokensToTerritory(testTerritory, 3);
		assertEquals(testTerritory.numofArmiesHere,5);
		assertEquals(testTerritory.isOwnedBy,5);
		assertEquals(testTerritory.isTaken,true);
	}

	@Test
	public void endturnTest(){
		player testPlayer = new player();
		assertEquals(testPlayer.endturn(),false);
	}
	
	@Test
	public void drawCardTest(){
		deck deck = new deck(42);
		player testPlayer = new player();
		List<card> hand = new ArrayList<card>();
		testPlayer.hand = hand;
		testPlayer.drawCard(deck);
		assertEquals(testPlayer.hand.size(),1);
	}
	///////////////////////////////////////////////////////////
	@Test
	public void processCardsTest(){
		board board = new board();
		deck deck = new deck(42);
		board.setDeck(deck);
		List<Integer> entries = new ArrayList<Integer>();
		entries.add(2);		
		player testPlayer = new player();
		testPlayer.playerNo = 1;
		testPlayer.setBoard(board);
		card card1 = new card('i',"territory1");
		card card2 = new card('a',"territory2");
		card card3 = new card('c',"territory3");
		List<card> hand = new ArrayList<card>();
		hand.add(card1);
		hand.add(card2);
		hand.add(card3);
		testPlayer.hand = hand;
		assertEquals(testPlayer.processCards(entries),0);
	}
	
	@Test
	public void getTerritoriesToFortifyFromTest() {
		player testPlayer = new player();
		assertEquals(testPlayer.getTerritoriesToFortifyFrom(0),"");
	} 
	
	@Test
	public void inputNameTest() throws IOException {
		player testPlayer = new player();
		testPlayer.inputName();
		assertEquals(Risk_Game.playersN.size(),1);
	} 
	
	@Test
	public void inputNameDuplicateTest() throws IOException {
		Risk_Game.playersN.add("test");
		player testPlayer = new player();
		testPlayer.playerName = "test";
		testPlayer.inputName();
		assertEquals(Risk_Game.playersN.size(),2);
	} 
	
	@Test
	public void printHandTest() throws IOException {
		player testPlayer = new player();
		card card1 = new card('i', "test1");
		card card2 = new card('a', "test2");
		testPlayer.hand.add(card1);
		testPlayer.hand.add(card2);
		assertEquals(testPlayer.printHand(),true);
	} 
	
	@Test
	public void chooseTerritoryTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 2;
		territory terr = new territory("test");
		testPlayer.chooseTerritory(terr);
		assertEquals(terr.getOwner(),2);
	} 
	
	@Test
	public void printTerritoriesTest() {
		player testPlayer = new player();
		testPlayer.playerNo = 2;
		territory terr = new territory("test");
		testPlayer.chooseTerritory(terr);
		testPlayer.territoriesOwned.add(terr);
		assertEquals(testPlayer.printTerritories(),true);
	} 
	
	@Test
	public void printTerritoriesAndAdjacenciesTest() throws Exception {
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		player testPlayer = new player();
		testPlayer.playerNo = 2;
		testPlayer.chooseTerritory(tList[2]);
		testPlayer.territoriesOwned.add(tList[2]);
		assertEquals(testPlayer.printTerritoriesAndAdjacencies(),true);
	} 
	
	@Test
	public void printTerritoriesOwnedTest() throws Exception {
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		player testPlayer = new player();
		testPlayer.playerNo = 2;
		testPlayer.chooseTerritory(tList[2]);
		testPlayer.territoriesOwned.add(tList[2]);
		assertEquals(testPlayer.printTerritoriesOwned(),true);
	} 
	
	@Test
	public void updateTerritoriesAfterBattleTest() throws Exception {
		territory[] tList = new territory[42];
		Risk_Game.initializeTerritories(tList);
		tList[2].numofArmiesHere = 5;
		tList[3].numofArmiesHere = 2;
		
		deck deckTest = new deck(42);

		player testPlayer = new player();
		testPlayer.playerNo = 1;
		testPlayer.chooseTerritory(tList[2]);
		testPlayer.territoriesOwned.add(tList[2]);
		
		player testPlayer2 = new player();
		testPlayer2.playerNo = 2;
		testPlayer2.chooseTerritory(tList[3]);
		testPlayer2.territoriesOwned.add(tList[3]);
		
		int attackerLost = 0;
		int defenderLost = 2;
		int advanceNum = 1;
		testPlayer.updateTerritoriesAfterBattle(tList[2],attackerLost,tList[3],defenderLost,advanceNum,deckTest);
		assertEquals(testPlayer.cardAlreadyPicked,true);
	} 
	 
}
