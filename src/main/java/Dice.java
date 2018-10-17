import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Dice {

	private int roll;
	private int[] diceArray;
    private Random die;

	/**
	 * Default constructor for dice.
	 */
    public Dice() {
	
    }

    /**
     * Returns an integer array of values between 1 and 6 representing the
     * outcome of rolling the dice.  The number of values in the array should be
     * between 1 and 3, depending on the number of dice rolled by the player.  The 
     * number of dice rolled by the player is specified by the argument numberOfDice
	 * @param numberOfDice the number of dice to be rolled
	 * @return the values of the dice
     **/
    public int[] roll(int numberOfDice) {
	
		diceArray = new int[numberOfDice];
		
		for(int i = 0; i < diceArray.length; i++) {
			die = new Random();
			roll = die.nextInt(5) + 1;
			diceArray[i] = roll;
		}
		if(numberOfDice > 0) {
			Arrays.sort(diceArray);
			Collections.reverse(Arrays.asList(diceArray));
		}
		return diceArray;
    }
}
