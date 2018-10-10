import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class territoryTest {

	@Test
	public void territoryTest1() {
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
	
	@Test
	public void territoryTest2() {
		String name = "name";
		int player = 1;
		int armies = 2;
		territory testTerritory = new territory(name,player,armies);
		assertEquals(testTerritory.name,name);
		assertEquals(testTerritory.isOwnedBy,player);
		assertEquals(testTerritory.numofArmiesHere,armies);
	}

	@Test
	public void territoryTest3() {
		String name = "name";
		int territoryNumber = 10;
		List<territory> terrs = new ArrayList<territory>();
		territory testTerritory = new territory(name,territoryNumber,terrs);
		assertEquals(testTerritory.name,name);
		assertEquals(testTerritory.territoryNumber,territoryNumber);
		assertEquals(testTerritory.adj_territories,terrs);
	}
}
