import java.io.Serializable;

//Class for the Risk cards
public class card implements Serializable {
  public char design;
  public String territory;

  public card(char design, String territory){
      this.design = design;
      this.territory = territory;
  }

  //Returns 'i' for infantry, 'c' for cavalry, 'a' for artillery, or 'w' for wild
  public char getDesign() {
      return design;
  }
  //Returns territory name or "wild"
  public String getTerritory(){
      return territory;
  }
  
  public String getCardType(){
	  String output = getDesign()+" "+this.getTerritory();
     return output;
  }
}
