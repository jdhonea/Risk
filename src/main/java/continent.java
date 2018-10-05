import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class continent implements Serializable {

	String name;
	List<territory> has; //TERRITORIES THAT MAKE UP THE CONTINENT
	int contVal;
	
	
	//CONSTRUCTORS
	public continent(String name) {
		this.name = name;
	}
	public continent(String name, List<territory> has) {
		this.name = name;
		this.has = has;
	}

	//////////METHODS///////////
	
	/**
	 * ADDS A LIST OF TERRITORIES TO THE CONTINENT
	 * 
	 */ 
	public void setTerritories(List<territory> list) {
		this.has = list;
	}
	
	/**
	 * ADDS VALUE TO THE CONTINENT
	 * 
	 */ 
	public void setContinentValue(int val) {
		this.contVal = val;
	}
	public int getContinentValue() {
		return this.contVal;
	}
	
	/**
	 * PRINTS THE LIST OF TERRITORIES OF THE CONTINENT
	 * 
	 */
	public void printContinentTerritories(){
		System.out.println("");
		System.out.println(name + " includes the following territories: ");
		for(int i = 0; i < has.size(); i++) {
			System.out.println(has.get(i).name);
		}
	}
	
	/**
	 * GETS THE LIST OF TERRITORIES OF THE CONTINENT
	 * 
	 */
	public List<territory> getTerritories(){
		return this.has;
	}
	public String getOwner(){
		String owner = has.get(0).getOwnerName();
		for (int n = 1; n < has.size(); n++){
			if (!has.get(n).getOwnerName().equals(owner))
				return "";
			//System.out.println(has.get(n).getnameofterritory());
		}
		return owner;
	}
	
}
