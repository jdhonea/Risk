import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class territoryTest {

	@Test
	public void territoryTest() {
		    String name = "name";
		    int player = 1;
		    int armies = 2;
		    List<territory> terrs = new ArrayList<territory>();
		    territory testTerritory = new territory(name,player,armies,terrs);
		    assertEquals(testTerritory.name,name);
		    assertEquals(testTerritory.isOwnedBy,player);
		    assertEquals(testTerritory.numofArmiesHere,armies);
		    assertEquals(testTerritory.adj_territories,terrs);
	}
}
