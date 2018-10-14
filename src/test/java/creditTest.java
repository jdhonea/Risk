import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

/** 
 * 
 */
public class creditTest {

	/**
	 * 
	 */
	@Test
	public void creditObjectTest(){
		credit testCredit = new credit();
		assertEquals(testCredit.creditValue,0);
	}
	@Test
	public void setCreditValueTest(){
		credit testCredit = new credit();
		testCredit.setCreditValue(20);
		assertEquals(testCredit.creditValue,20);
		assertEquals(testCredit.getCreditValue(),20);
	}
	@Test
	public void exchangeForCardTest(){
		String terr = "territory"; 
		credit testCredit = new credit();
		card testCard = testCredit.exchangeForCard('i', terr);
		assertEquals(testCard.design,'i');
		assertEquals(testCard.territory,terr);
	}
	@Test
	public void exchangeForUndoTest(){
		credit testCredit = new credit();
		int test = testCredit.exchangeForUndo();
		assertEquals(test,1);
	}
	@Test
	public void tradeCreditsTest(){
		player player1 = new player();
		player1.credits.setCreditValue(30);
		player player2 = new player();
		player2.credits.setCreditValue(5);
		credit testCredit = new credit();
		int[] output = testCredit.tradeCredits(player1, player2, 15);
		player1.credits.setCreditValue(output[0]);
		player2.credits.setCreditValue(output[1]);
		assertEquals(player1.credits.creditValue,15);
		assertEquals(player2.credits.creditValue,20);
	} 
}
