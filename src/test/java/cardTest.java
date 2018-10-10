import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

public class cardTest {

	@Test
	public void cardTest() {
		char design = 'i';
		String territory = "testTerritory";
		String output = design+" "+territory;
		card testCard = new card(design,territory);
		assertEquals(testCard.getDesign(),design);
		assertEquals(testCard.getTerritory(),territory);
		assertEquals(testCard.getCardType(),output);
	}
}	
