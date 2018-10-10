import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

public class continentTest {

	@Test
	public void continentTest1() {
		String name = "testContinent";
		continent contTest = new continent(name);
		assertEquals(contTest.name,name);
	}
	
	@Test
	public void continentTest2() {
		String name = "testContinent";
		List<territory> has = new ArrayList<territory>();
		continent contTest = new continent(name,has);
		assertEquals(contTest.name,name);
		assertEquals(contTest.has,has);
	}
	
}
