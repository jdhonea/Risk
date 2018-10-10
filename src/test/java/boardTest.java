import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

public class boardTest {

	@Test
	public void boardTest() {
		territory[] tList = new territory[42];
		deck deck = new deck(42);
		board testBoard = new board(tList,deck);

		assertEquals(testBoard.europe.name,"Europe");
		assertEquals(testBoard.N_Amer.name,"North America");
		assertEquals(testBoard.asia.name,"Asia");
		assertEquals(testBoard.africa.name,"Africa");
		assertEquals(testBoard.S_Amer.name,"South America");
		assertEquals(testBoard.australia.name,"Australia");
		
		assertEquals(testBoard.europe.getContinentValue(),5);
		assertEquals(testBoard.N_Amer.getContinentValue(),5);
		assertEquals(testBoard.asia.getContinentValue(),7);
		assertEquals(testBoard.africa.getContinentValue(),3);
		assertEquals(testBoard.S_Amer.getContinentValue(),2);
		assertEquals(testBoard.australia.getContinentValue(),2);
		
		assertEquals(testBoard.tList,tList);
	}
	
}
