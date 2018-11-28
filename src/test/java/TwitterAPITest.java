import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import twitter4j.TwitterException;

public class TwitterAPITest {

	@Test
	public void loadPropertyFileTest() {
		TwitterAPI twitTest = new TwitterAPI();
		twitTest.loadPropertyFile("secrets_RISK_TAKERS.prop");
		assertEquals(twitTest.prop.getProperty("secret"),null);
	}
	
}	
