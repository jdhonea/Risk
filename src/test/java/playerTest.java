import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/** 
 * CLASS TO TEST ALL METHODS OF THE PLAYER OBJECT
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
	public void playerTooManyTest(){
		int num = 7;
		player testPlayer = new player(num);
		assertEquals(testPlayer.playerNo,0);
	}
	
	@Test
	public void playerTooFewTest(){
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
}
