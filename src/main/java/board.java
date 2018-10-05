import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class board implements Serializable{
		territory[] tList;
		continent europe;
		continent europewithTerr;
		continent N_Amer;
		continent nawithTerr;
		continent asia;
		continent asiawithTerr;
		continent africa;
		continent afrwithTerr;
		continent S_Amer;
		continent sawithTerr;
		continent australia;
		continent auswithTerr;
		List<continent> map;
		deck deck;
		List<player>pList;
	
	//constructor
		public board(){};
		public board(territory[] tList, deck deck) {
			//ADD CONTINENTS TO BOARD
			this.europe = new continent("Europe");
			this.europe.setContinentValue(5);
			this.N_Amer = new continent("North America");
			this.N_Amer.setContinentValue(5);
			this.asia = new continent("Asia");
			this.asia.setContinentValue(7);
			this.africa = new continent("Africa");
			this.africa.setContinentValue(3);
			this.S_Amer = new continent("South America");
			this.S_Amer.setContinentValue(2);
			this.australia = new continent("Australia");
			this.australia.setContinentValue(2);
			this.tList = tList;
			initializeBoard();
		}
		public continent getContinentByNum(int n){
			if(n > -1 && n < map.size())
				return map.get(n);
			else
				return new continent("Error");
		}

		public int getNumOfContinents(){return map.size();};

		//sets the player list to board
		public void setPlayerList(List<player> pList){
			this.pList = pList;
		}

		//returns the player list
		public List<player> getPlayerList(){
			return this.pList;
		}

		//sets the deck to the board
		public void setDeck(deck deck){
			this.deck = deck;
		}

		//returns the deck
		public deck getDeck(){
			return this.deck;
		}

		private void initializeBoard() {
			//LIST OF CONTINENTS
			List<continent> continent = new ArrayList<continent>(6);
			{
				continent.add(europe);
				continent.add(N_Amer);
				continent.add(asia);
				continent.add(africa);
				continent.add(S_Amer);
				continent.add(australia);

				//ADD TERRITORIES TO EACH CONTINENT
				List<territory> europeList = new ArrayList<territory>(7);
				for (int n = 13; n < 20; n++) {
					europeList.add(tList[n]);
				}
				this.europewithTerr = new continent("Europe", europeList);
				this.europewithTerr.setContinentValue(5);

				List<territory> naList = new ArrayList<territory>(9);
				for (int n = 0; n < 9; n++) {
					naList.add(tList[n]);
				}
				this.nawithTerr = new continent("North America", naList);
				this.nawithTerr.setContinentValue(5);

				List<territory> asiaList = new ArrayList<territory>(12);
				for (int n = 26; n < 38; n++) {
					asiaList.add(tList[n]);
				}
				this.asiawithTerr = new continent("Asia", asiaList);
				this.asiawithTerr.setContinentValue(7);

				List<territory> saList = new ArrayList<territory>(4);
				for (int n = 9; n < 13; n++) {
					saList.add(tList[n]);
				}
				this.sawithTerr = new continent("South America", saList);
				this.sawithTerr.setContinentValue(2);

				List<territory> afrList = new ArrayList<territory>(6);
				for (int n = 20; n < 26; n++) {
					afrList.add(tList[n]);
				}
				this.afrwithTerr = new continent("Africa", afrList);
				this.afrwithTerr.setContinentValue(3);

				List<territory> ausList = new ArrayList<territory>(4);
				for (int n = 38; n < 42; n++) {
					ausList.add(tList[n]);
				}
				this.auswithTerr = new continent("Australia", ausList);
				this.auswithTerr.setContinentValue(2);
				//METHODS
			}
			map = new ArrayList<continent>();
			map.add(europewithTerr);
			map.add(nawithTerr);
			map.add(asiawithTerr);
			map.add(sawithTerr);
			map.add(afrwithTerr);
			map.add(auswithTerr);
	}
	
	
}
