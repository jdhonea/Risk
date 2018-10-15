//package com.risktakers.Risk;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Handles the individual territories.
 */
public class territory implements Serializable{

	int num_of_territories = 42;
	int territoryNumber;
	String name;
	String ownerName;
	int numofArmiesHere = 0;
	boolean isTaken = false;
	int isOwnedBy;
	List<String> adj_territories_list;
	List<territory> adj_territories;

	/**
	 * Territory constructor.
	 * @param name	name of the territory
	 * @param player	name of the player that owns the territory
	 * @param armies	number of armies present in the territory
	 * @param terrs	list of adjacent territories
	 */
	public territory(String name, int player, int armies, List<territory> terrs) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
		this.adj_territories = terrs;
	}

	/**
	 * Territory constructor.
	 * @param name name of the territory
	 * @param player	name of the player that owns the territory
	 * @param armies	number of armies present in the territory
	 */
	public territory(String name, int player, int armies) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
	}

	/**
	 * Territory constructor.
	 * @param name name of the territory
	 * @param territoryNumber	number associated with the territory
	 * @param adjacentList list of adjacent territories
	 */
	public territory(String name, int territoryNumber, List<territory> adjacentList) {
		this.name = name;
		this.territoryNumber = territoryNumber;
		this.adj_territories = adjacentList;
	}

	/**
	 * Territory constructor.
	 * @param name	name of the territory
	 * @param territoryNumber	number associated with the territory
	 */
	public territory(String name, int territoryNumber) {
		this.name = name;
		this.territoryNumber = territoryNumber;
	}

	/**
	 * Territory constructor.
	 * @param name	name of the territory
	 */
	public territory(String name) {
		this.name = name;
	}

	/**
	 * Default territory constructor.
	 */
	public territory() {
	}
	
	/**
	 * METHODS
	 */
	/**
	 * Returns the number associated with the territory.
	 * @return	number associated with the territory
	 */
	public int getTerritoryNumber(){
		return this.territoryNumber;
	}

	/**
	 * Sets the name of the territory.
	 * @param territory the name of the territory
	 */
	public void setnameofterritory(String territory) {
		this.name = territory;
	}

	/**
	 * Gets the name of the territory.
	 * @return name of the territory
	 */
	public String getnameofterritory() {
		return this.name;
	}

	/**
	 * Sets the taken status of the territory, whether a player owns it or not.
	 * @param set taken status
	 */
	public void setTaken(boolean set) {
		this.isTaken = set;
	}

	/**
	 * Checks whether the territory is taken or not.
	 * @return	true if territory is taken and false if not
	 */
	public boolean isTaken() {
		return this.isTaken;
	}

	/**
	 * Sets the owner of the territory to the player by player number.
	 * @param owner	player number that owns the territory
	 */
	public void setOwner(int owner) {
		this.isOwnedBy = owner;
	}

	/**
	 * Gets the player number that owns this territory.
	 * @return the number of the player that owns the territory
	 */
	public int getOwner() {
		return this.isOwnedBy;
	}

	/**
	 * Sets the territory owner's name.
	 * @param owner string containing the owner's name
	 */
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}

	/**
	 * Returns a string containing the territory owner's name.
	 * @return the owner's name
	 */
	public String getOwnerName() {
		return this.ownerName;
	}

	/**
	 * Changes the territory's owner name and number to the new owner.
	 * @param p	new owner's player object
	 */
	public void changeOwner(player p){
		this.setOwner(p.playerNo);
		this.setOwnerName(p.getPlayerName());
	}

	/**
	 * Sets the number of armies currently in the territory.
	 * @param armies the number of armies present
	 */
	public void setnumberofarmies(int armies) {
		this.numofArmiesHere = armies;
	}

	/**
	 * Gets the number of armies present in the territory.
	 * @return the number of armies
	 */
	public int getnumofarmies() {
		return this.numofArmiesHere;
	}

	/**
	 * Adds a new army to the territory.
	 */
	public void addTokenToTerritory() {
		this.numofArmiesHere = numofArmiesHere + 1;
	}

	/**
	 * Adds multiple armies to a territory.
	 * @param tokenNumber number of armies to be added
	 */
	public void addTokensToTerritory(int tokenNumber) {
		this.numofArmiesHere = numofArmiesHere + tokenNumber;
	}

	/**
	 * Sets the adjacent territories list for the territory.
	 * @param list the list of adjacent territories
	 */
	public void setAdjacentterritories(List<territory> list) {
		this.adj_territories = list;
	}

	/**
	 * Gets all territories adjacent to the current territory.
	 * @param place
	 * @return the list of adjacent territories
	 */
	public List<territory> getAdjacentterritories(territory place) {
		List<territory> dummy = new ArrayList<territory>();
		adjacentTerritoriesLists adjTL = new adjacentTerritoriesLists();
		for(List<territory> tL : adjTL.adjList) {
			if(this.adj_territories.equals(tL)) {
				return this.adj_territories;
			}
		}
		return dummy;
	}
}
