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
		player testPlayer = new player(7);
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
	

}
