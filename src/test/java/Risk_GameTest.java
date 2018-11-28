import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class Risk_GameTest {
@Test
    public void undoTest(){
        board testBoard = new board();
        byte[] testArray = Risk_Game.saveState(testBoard);
        board newTestBoard = Risk_Game.restoreData(testArray);
        byte[] newTestarray = Risk_Game.saveState(newTestBoard);
        assertArrayEquals(testArray, newTestarray);
    }
}
