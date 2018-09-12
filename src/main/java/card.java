//Class for the Risk cards

public class card {
    private char design;
    private String territory;

    public card(char design, String territory){
        this.design = design;
        this.territory = territory;
    }

    //Returns 'i' for infantry, 'c' for cavalry, 'a' for artillery, or 'w' for wild
    public char getDesign() {
        return this.design;
    }
    //Returns territory name or "wild"
    public String getTerritory(){
        return this.territory;
    }
}
