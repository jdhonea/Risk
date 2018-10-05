//package com.risktakers.Risk;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
	
	//constructors
	public territory(String name, int player, int armies, List<territory> terrs) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
		this.adj_territories = terrs;
	}
	public territory(String name, int player, int armies) {
		this.name = name;
		this.numofArmiesHere = armies;
		this.isOwnedBy = player;
	}
	public territory(String name, int territoryNumber, List<territory> adjacentList) {
		this.name = name;
		this.territoryNumber = territoryNumber;
		this.adj_territories = adjacentList;
	}
	public territory(String name, int territoryNumber) {
		this.name = name;
		this.territoryNumber = territoryNumber;
	}
	public territory(String name) {
		this.name = name;
	}
	public territory() {
	}
	
	/**
	 * METHODS
	 */
	//name
	public int getTerritoryNumber(){
		return this.territoryNumber;
	}
	public void setnameofterritory(String territory) {
		this.name = territory;
	}
	public String getnameofterritory() {
		return this.name;
	}
	
	//is it owned?
	public void setTaken(boolean set) {
		this.isTaken = set;
	}
	public boolean isTaken() {
		return this.isTaken;
	}
	
	//owner
	public void setOwner(int owner) {
		this.isOwnedBy = owner;
	}
	public int getOwner() {
		return this.isOwnedBy;
	}
	
	//owner
	public void setOwnerName(String owner) {
		this.ownerName = owner;
	}
	public String getOwnerName() {
		return this.ownerName;
	}

	public void changeOwner(player p){
		this.setOwner(p.playerNo);
		this.setOwnerName(p.getPlayerName());
	}
	
	//number of armies
	public void setnumberofarmies(int armies) {
		this.numofArmiesHere = armies;
	}
	public int getnumofarmies() {
		return this.numofArmiesHere;
	}
	
	//ADD TOKEN/ARMIES TO TERRITORY
	public void addTokenToTerritory() {
		this.numofArmiesHere = numofArmiesHere + 1;
	}
	public void addTokensToTerritory(int tokenNumber) {
		this.numofArmiesHere = numofArmiesHere + tokenNumber;
	}

	//adjacent territories
	public void setAdjacentterritories(List<territory> list) {
		this.adj_territories = list;
	}
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
