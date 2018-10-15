import java.io.Serializable;

/**
 * Handles the individual cards from the Risk deck.
 */
public class card implements Serializable {
  public char design;
  public String territory;

    /**
     * Constructor for the card class. Takes a design char ('a','i','c','w') and a territory name.
     * @param design    a - artillery, c - cavalry, i - infantry, w - wild
     * @param territory the name of the territory the card is representing
     */
  public card(char design, String territory){
      this.design = design;
      this.territory = territory;
  }

    /**
     * Returns the design of the card; returns 'a' for artillery, 'i' for infantry, 'c' for cavalry, and 'w' for wild cards
     * @return  returns 'a','c','i', or 'w' corresponding to the card design
     */
  public char getDesign() {
      return design;
  }

    /**
     * Returns a the name of the territory on the card as a string
     * @return  a string containing the name of the territory the card represents
     */
  public String getTerritory(){
      return territory;
  }

    /**
     * Returns a string that contains the card design and the card name. Used for easily printing cards.
     * @return  a string containing the design and name
     */
  public String getCardType(){
	  String output = getDesign()+" "+this.getTerritory();
     return output;
  }
}
