import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class diceTest {
    @Test
    public void oneDieThrown(){
        Dice dice = new Dice();
        int[] roll = dice.roll(1);
        assertTrue(roll[0] <= 6);
        assertTrue(roll[0] > 0);
    }
    @Test
    public void twoDiceThrown(){
        Dice dice = new Dice();
        int[] roll = dice.roll(2);
        for(int n = 0; n < 2; n++){
            assertTrue(roll[n] <= 6);
            assertTrue(roll[n] > 0);
        }
    }
    @Test
    public void threeDiceThrown(){
        Dice dice = new Dice();
        int[] roll = dice.roll(3);
        for(int n = 0; n < 3; n++){
            assertTrue(roll[n] <= 6);
            assertTrue(roll[n] > 0);
        }
    }
    @Test
    public void noDiceThrown(){
        Dice dice = new Dice();
        dice.roll(0);
    }
}
