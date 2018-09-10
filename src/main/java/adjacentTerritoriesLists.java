import java.util.ArrayList;
import java.util.List;

public class adjacentTerritoriesLists {

	public List<territory> alaskaList = new ArrayList<territory>();
	public List<territory> albertaList = new ArrayList<territory>();
	public List<territory> centralAmericaList = new ArrayList<territory>();
	public List<territory> easternUnitedStatesList = new ArrayList<territory>();
	public List<territory> greenlandList = new ArrayList<territory>();
	public List<territory> northwestTerritoryList = new ArrayList<territory>();
	public List<territory> ontarioList = new ArrayList<territory>();
	public List<territory> quebecList = new ArrayList<territory>();
	public List<territory> westernUnitedStatesList = new ArrayList<territory>();
	public List<territory> argentinaList = new ArrayList<territory>();
	public List<territory> brazilList = new ArrayList<territory>();
	public List<territory> peruList = new ArrayList<territory>();
	public List<territory> venezuelaList = new ArrayList<territory>();
	public List<territory> greatBritainList = new ArrayList<territory>();
	public List<territory> icelandList = new ArrayList<territory>();
	public List<territory> northernEuropeList = new ArrayList<territory>();
	public List<territory> scandinaviaList = new ArrayList<territory>();
	public List<territory> southernEuropeList = new ArrayList<territory>();
	public List<territory> ukraineList = new ArrayList<territory>();
	public List<territory> westernEuropeList = new ArrayList<territory>();
	public List<territory> congoList = new ArrayList<territory>();
	public List<territory> eastAfricaList = new ArrayList<territory>();
	public List<territory> egyptList = new ArrayList<territory>();
	public List<territory> madagascarList = new ArrayList<territory>();
	public List<territory> northAfricaList = new ArrayList<territory>();
	public List<territory> southAfricaList = new ArrayList<territory>();
	public List<territory> afghanistanList = new ArrayList<territory>();
	public List<territory> chinaList = new ArrayList<territory>();
	public List<territory> indiaList = new ArrayList<territory>();
	public List<territory> irkutskList = new ArrayList<territory>();
	public List<territory> japanList = new ArrayList<territory>();
	public List<territory> kamchatkaList = new ArrayList<territory>();
	public List<territory> middleEastList = new ArrayList<territory>();
	public List<territory> mongoliaList = new ArrayList<territory>();
	public List<territory> siamList = new ArrayList<territory>();
	public List<territory> siberiaList = new ArrayList<territory>();
	public List<territory> uralList = new ArrayList<territory>();
	public List<territory> yakutskList = new ArrayList<territory>();
	public List<territory> easternAustraliaList = new ArrayList<territory>();
	public List<territory> indonesiaList = new ArrayList<territory>();
	public List<territory> newGuineaList = new ArrayList<territory>();
	public List<territory> westernAustraliaList = new ArrayList<territory>();
	
	public List<List<territory>> adjList = new ArrayList<List<territory>>(42);

	
	public adjacentTerritoriesLists() {
		alaskaList.add(new territory("Kamchatka",32));
		alaskaList.add(new territory("Northwest Territory",6));
		alaskaList.add(new territory("Alberta,2"));
		
		albertaList.add(new territory("Alaska",1,1));
		albertaList.add(new territory("Northwest Territory",6));
		albertaList.add(new territory("Ontario",7));
		albertaList.add(new territory("Western United States",9));
		
		centralAmericaList.add(new territory("Western United States",9));
		centralAmericaList.add(new territory("Eastern United States",4));
		centralAmericaList.add(new territory("Venezuela",13));
		
		easternUnitedStatesList.add(new territory("Western United States",9));
		easternUnitedStatesList.add(new territory("Quebec",8));
		easternUnitedStatesList.add(new territory("Ontario",7));
		easternUnitedStatesList.add(new territory("Central America",3));

		greenlandList.add(new territory("Quebec",8));
		greenlandList.add(new territory("Iceland",15));
		
		northwestTerritoryList.add(new territory("Alaska",1));
		northwestTerritoryList.add(new territory("Alberta",2));
		northwestTerritoryList.add(new territory("Ontario",7));
		northwestTerritoryList.add(new territory("Greenland",5));
		
		ontarioList.add(new territory("Northwest Territory",6));
		ontarioList.add(new territory("Alberta",2));
		ontarioList.add(new territory("Western United States",9));
		ontarioList.add(new territory("Eastern United States",4));
		ontarioList.add(new territory("Greenland",5));
		ontarioList.add(new territory("Quebec",8));
		
		quebecList.add(new territory("Ontario",7));
		quebecList.add(new territory("Eastern United States",4));
		quebecList.add(new territory("Greenland",5));
		
		westernUnitedStatesList.add(new territory("Ontario",7));
		westernUnitedStatesList.add(new territory("Alberta",2));
		westernUnitedStatesList.add(new territory("Central America",3));
		westernUnitedStatesList.add(new territory("Eastern United States",4));
		
		argentinaList.add(new territory("Peru",12));
		argentinaList.add(new territory("Brazil",11));
		
		brazilList.add(new territory("Venezuela",13));
		brazilList.add(new territory("Peru",12));
		brazilList.add(new territory("Argentina",10));
		brazilList.add(new territory("North Africa",25));
		
		peruList.add(new territory("Venezuela",13));
		peruList.add(new territory("Brazil",11));
		peruList.add(new territory("Argentina",10));
		
		venezuelaList.add(new territory("Central America",3));
		venezuelaList.add(new territory("Brazil",11));
		venezuelaList.add(new territory("Peru",12));
		
		greatBritainList.add(new territory("Iceland",15));
		greatBritainList.add(new territory("Scandinavia",17));
		greatBritainList.add(new territory("Northern Europe",16));
		greatBritainList.add(new territory("Western Europe",20));
		
		icelandList.add(new territory("Greenland",5));
		icelandList.add(new territory("Great Britain",14));
		icelandList.add(new territory("Scandinavia",17));
		
		northernEuropeList.add(new territory("Scandinavia",17));
		northernEuropeList.add(new territory("Ukraine",19));
		northernEuropeList.add(new territory("Southern Europe",18));
		northernEuropeList.add(new territory("Western Europe",20));
		northernEuropeList.add(new territory("Great Britain",14));
		
		scandinaviaList.add(new territory("Iceland",15));
		scandinaviaList.add(new territory("Great Britain",14));
		scandinaviaList.add(new territory("Northern Europe",16));
		scandinaviaList.add(new territory("Ukraine",19));
		
		southernEuropeList.add(new territory("Western Europe",20));
		southernEuropeList.add(new territory("Ukraine",19));
		southernEuropeList.add(new territory("Middle East",33));
		southernEuropeList.add(new territory("Egypt",23));
		southernEuropeList.add(new territory("North Africa",25));
		
		ukraineList.add(new territory("Scandinavia",17));
		ukraineList.add(new territory("Northern Europe",16));
		ukraineList.add(new territory("Southern Europe",18));
		ukraineList.add(new territory("Middle East",33));
		ukraineList.add(new territory("Afghanistan",27));
		ukraineList.add(new territory("Ural",37));
		
		westernEuropeList.add(new territory("Great Britain",14));
		westernEuropeList.add(new territory("Northern Europe",16));
		westernEuropeList.add(new territory("Southern Europe",18));
		westernEuropeList.add(new territory("North Africa",25));
		
		congoList.add(new territory("North Africa",25));
		congoList.add(new territory("East Africa",22));
		congoList.add(new territory("South Africa",26));
		
		eastAfricaList.add(new territory("Egypt",23));
		eastAfricaList.add(new territory("Middle East",33));
		eastAfricaList.add(new territory("North Africa",25));
		eastAfricaList.add(new territory("Congo",21));
		eastAfricaList.add(new territory("South Africa",26));
		eastAfricaList.add(new territory("Madagascar",24));
		
		egyptList.add(new territory("East Africa",22));
		egyptList.add(new territory("Middle East",33));
		egyptList.add(new territory("Southern Europe",18));
		egyptList.add(new territory("North Africa",25));
		
		madagascarList.add(new territory("South Africa",26));
		madagascarList.add(new territory("East Africa",22));
		
		northAfricaList.add(new territory("Egypt",23));
		northAfricaList.add(new territory("Southern Europe",18));
		northAfricaList.add(new territory("East Africa",22));
		northAfricaList.add(new territory("Congo",21));
		northAfricaList.add(new territory("Brazil,11"));
		northAfricaList.add(new territory("Western Europe",20));
		
		southAfricaList.add(new territory("Congo",21));
		southAfricaList.add(new territory("East Africa",22));
		southAfricaList.add(new territory("Madagascar",24));
		
		afghanistanList.add(new territory("Middle East",33));
		afghanistanList.add(new territory("Ukraine",19));
		afghanistanList.add(new territory("Ural",37));
		afghanistanList.add(new territory("India",29));
		afghanistanList.add(new territory("China",28));
		
		chinaList.add(new territory("Siam",35));
		chinaList.add(new territory("India",29));
		chinaList.add(new territory("Afghanistan",27));
		chinaList.add(new territory("Ural",37));
		chinaList.add(new territory("Siberia",36));
		chinaList.add(new territory("Mongolia",34));
		
		indiaList.add(new territory("Middle East",33));
		indiaList.add(new territory("Afghanistan",27));
		indiaList.add(new territory("Siam",35));
		indiaList.add(new territory("China",28));
		
		irkutskList.add(new territory("Siberia",36));
		irkutskList.add(new territory("Yakutsk",38));
		irkutskList.add(new territory("Kamchatka",32));
		irkutskList.add(new territory("Mongolia",34));
		
		japanList.add(new territory("Mongolia",34));
		japanList.add(new territory("Kamchatka",32));
		
		kamchatkaList.add(new territory("Yakutsk",38));
		kamchatkaList.add(new territory("Irkutsk",30));
		kamchatkaList.add(new territory("Mongolia",34));
		kamchatkaList.add(new territory("Japan",31));
		kamchatkaList.add(new territory("Alaska",1));
		
		middleEastList.add(new territory("Southern Europe",18));
		middleEastList.add(new territory("Ukraine",19));
		middleEastList.add(new territory("Afghanistan",27));
		middleEastList.add(new territory("India",29));
		middleEastList.add(new territory("Egypt",23));
		middleEastList.add(new territory("East Africa",22));
		
		mongoliaList.add(new territory("Siberia",36));
		mongoliaList.add(new territory("Irkutsk",30));
		mongoliaList.add(new territory("Kamchatka",32));
		mongoliaList.add(new territory("Japan",31));
		mongoliaList.add(new territory("China",28));
		
		siamList.add(new territory("India",29));
		siamList.add(new territory("Indonesia",40));
		siamList.add(new territory("China",28));
		
		siberiaList.add(new territory("Ural",37));
		siberiaList.add(new territory("Irkutsk",30));
		siberiaList.add(new territory("Yakutsk",38));
		siberiaList.add(new territory("Mongolia",34));
		siberiaList.add(new territory("China",28));
		
		uralList.add(new territory("Ukraine",19));
		uralList.add(new territory("Afghanistan",27));
		uralList.add(new territory("Siberia",36));
		uralList.add(new territory("China",28));
		
		yakutskList.add(new territory("Kamchatka",32));
		yakutskList.add(new territory("Irkutsk",30));
		yakutskList.add(new territory("Siberia",36));
		
		easternAustraliaList.add(new territory("Western Australia",42));
		easternAustraliaList.add(new territory("New Guinea",41));
		
		indonesiaList.add(new territory("Siam",35));
		indonesiaList.add(new territory("New Guinea",41));
		indonesiaList.add(new territory("Western Australia",42));
		
		newGuineaList.add(new territory("Indonesia",40));
		newGuineaList.add(new territory("Eastern Australia",39));
		newGuineaList.add(new territory("Western Australia",42));
		
		westernAustraliaList.add(new territory("Eastern Australia",39));
		westernAustraliaList.add(new territory("New Guinea",41));
		westernAustraliaList.add(new territory("Indonesia",40));
		
		adjList.add(alaskaList);
		adjList.add(albertaList);
		adjList.add(centralAmericaList);
		adjList.add(easternUnitedStatesList);
		adjList.add(greenlandList);
		adjList.add(northwestTerritoryList);
		adjList.add(ontarioList);
		adjList.add(quebecList);
		adjList.add(westernUnitedStatesList);
		adjList.add(argentinaList);
		adjList.add(brazilList);
		adjList.add(peruList);
		adjList.add(venezuelaList);
		adjList.add(greatBritainList);
		adjList.add(icelandList);
		adjList.add(northernEuropeList);
		adjList.add(scandinaviaList);
		adjList.add(southernEuropeList);
		adjList.add(ukraineList);
		adjList.add(westernEuropeList);
		adjList.add(congoList);
		adjList.add(eastAfricaList);
		adjList.add(egyptList);
		adjList.add(madagascarList);
		adjList.add(northAfricaList);
		adjList.add(southAfricaList);
		adjList.add(afghanistanList);
		adjList.add(chinaList);
		adjList.add(indiaList);
		adjList.add(irkutskList);
		adjList.add(japanList);
		adjList.add(kamchatkaList);
		adjList.add(middleEastList);
		adjList.add(mongoliaList);
		adjList.add(siamList);
		adjList.add(siberiaList);
		adjList.add(uralList);
		adjList.add(yakutskList);
		adjList.add(easternAustraliaList);
		adjList.add(indonesiaList);
		adjList.add(newGuineaList);
		adjList.add(westernAustraliaList);
		
	}
	
	public List<territory> get(int index){
		
		return adjList.get(index);
		
	}
	
}
