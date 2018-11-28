import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

public class GameTimerTest {

	@Test
	public void GameTimer() {
		BufferedReader reader = null;
		String[] checker = {"0",""};
		String testStr = "";
		GameTimer gTimer = new GameTimer();
		String[] input = gTimer.GameTimerTask(reader, testStr);
		assertEquals(input[0],"0");
		assertEquals(input[1],"");
	}
	
}	
