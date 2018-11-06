import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameTimer {
	
	public GameTimer() {		
	}
	
    public String[] GameTimerTask(BufferedReader reader, String input) {
    	String[] output = new String[2];
    	reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int x = 30; // wait 30 seconds at most
			long startTime = System.currentTimeMillis();
			while ((System.currentTimeMillis() - startTime) < x * 1000
			        && !reader.ready()) {
			}
			if (reader.ready()) {
				input = reader.readLine();
				output[0] = "-1";
				output[1] = input;
			    return output;
			} else {
				output[0] = "0";
				output[1] = input;
			    return output;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		output[0] = "0";
		output[1] = input;
		return output;
	}
}
