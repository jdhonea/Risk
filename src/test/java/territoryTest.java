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
	
	@Test
	public void getTerritoryNumberTest() {
		territory testTerritory = new territory();
		testTerritory.territoryNumber = 5;
		assertEquals(testTerritory.getTerritoryNumber(),5);
	}

	@Test
	public void setnameofterritoryTest() {
		String territory = "testName";
		territory testTerritory = new territory();
		testTerritory.setnameofterritory(territory);
		assertEquals(testTerritory.name,territory);
	}
	
	@Test
	public void getnameofterritoryTest() {
		String territory = "testName";
		territory testTerritory = new territory();
		testTerritory.setnameofterritory(territory);
		assertEquals(testTerritory.getnameofterritory(),territory);
	}
	
	@Test
	public void setTakenTrueTest() {
		territory testTerritory = new territory();
		testTerritory.setTaken(true);
		assertEquals(testTerritory.isTaken(),true);
	}
	
	@Test
	public void setTakenFalseTest() {
		territory testTerritory = new territory();
		testTerritory.setTaken(false);
		assertEquals(testTerritory.isTaken(),false);
	}
	
	@Test
	public void setOwnerTest() {
		int owner = 1;
		territory testTerritory = new territory();
		testTerritory.setOwner(owner);
		assertEquals(testTerritory.isOwnedBy,owner);
	}
	
	@Test
	public void getOwnerTest() {
		int owner = 1;
		territory testTerritory = new territory();
		testTerritory.setOwner(owner);
		assertEquals(testTerritory.getOwner(),owner);
	}
	
	@Test
	public void setOwnerNameTest() {
		String owner = "testName";
		territory testTerritory = new territory();
		testTerritory.setOwnerName(owner);
		assertEquals(testTerritory.ownerName,owner);
	}
	
	@Test
	public void getOwnerNameTest() {
		String owner = "testName";
		territory testTerritory = new territory();
		testTerritory.setOwnerName(owner);
		assertEquals(testTerritory.getOwnerName(),owner);
	}
}
