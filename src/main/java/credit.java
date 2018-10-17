import java.io.Serializable;

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
	
	public card exchangeForCard(char design,String territory) {
		char cardDesign = design;
		String cardTerritory = territory;
		card cardChosen = new card(cardDesign,cardTerritory);
		//TODO:ADD CARD TO PLAYER HAND
		return cardChosen; 
	}
	
	public int exchangeForUndo() {
		this.numOfUndoActions++;
		return this.numOfUndoActions;
	}
	
	public int[] tradeCredits(player player1,player player2,int numOfcredits) {
		int[] output = new int[2];
		int val1 = player1.credits.creditValue - numOfcredits;
		int val2 = player2.credits.creditValue + numOfcredits;
		output[0] = val1;
		output[1] = val2;
		return output; 
	}
}
