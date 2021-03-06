import java.io.Serializable;

/**
 * 
 * CREDIT CLASS
 */
public class credit implements Serializable {
	
	int numOfUndoActions;
	int creditValue;
	//////////CONSTRUCTORS//////////////////
	public credit() {
		this.creditValue = 0;
		this.numOfUndoActions = 0;
	}
	
	////////////METHODS//////////////
	public void setCreditValue(int val) {
		this.creditValue = val;
	}
	
	public int getCreditValue() {
		return this.creditValue;
	}
	
	/**
	 * EXCHANGE CREDIT FOR A SPECIFIC TYPE OF CARD
	 */	
	public card exchangeForCard(char design,String territory) {
		char cardDesign = design;
		String cardTerritory = territory;
		card cardChosen = new card(cardDesign,cardTerritory);
		return cardChosen; 
	}
	
	/**
	 * EXCHANGE CREDIT FOR UNDO
	 */	
	public int exchangeForUndo() {
		this.numOfUndoActions++;
		return this.numOfUndoActions;
	}
	
	/**
	 * TRANSFER CREDIT TO ANOTHER PLAYER
	 */	
	public int[] transferCredits(player player1,player player2,int numOfcredits) {
		int[] output = new int[2];
		int val1 = player1.credits.creditValue - numOfcredits;
		int val2 = player2.credits.creditValue + numOfcredits;
		output[0] = val1;
		output[1] = val2;
		System.out.println(player1.playerName+" transferred "+numOfcredits+" credits to "+player2.playerName+"\n");
		return output; 
	}
}
