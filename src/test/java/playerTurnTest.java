import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

public class playerTurnTest {

	@Test
	public void playerTurnTest1() {
		playerTurn testTurn = new playerTurn();
		assertEquals(testTurn.valid,true);
	}

	@Test
	public void playerTurnTest2() {
		player p = new player();
		board b = new board();
		playerTurn testTurn = new playerTurn(p,b);
		assertEquals(testTurn.player,p);
		assertEquals(testTurn.board,b);
	}

}
