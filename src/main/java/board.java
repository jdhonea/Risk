import java.util.ArrayList;
import java.util.List;

public class board {

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
	
	//constructor
		public board() {
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
		}
	
	//LIST OF CONTINENTS
	List<continent> continent = new ArrayList<continent>(6);{
	continent.add(europe);
	continent.add(N_Amer);
	continent.add(asia);
	continent.add(africa);
	continent.add(S_Amer);
	continent.add(australia);
	
	//ADD TERRITORIES TO EACH CONTINENT
	List<territory> europeList = new ArrayList<territory>(7);
	territory gb = new territory("GB");
	territory ice = new territory("Iceland");
	territory ne = new territory("Northern Europe");
	territory s = new territory("Scandinavia");
	territory se = new territory("Southern Europe");
	territory u = new territory("Ukraine");
	territory we = new territory("Western Europe");
	europeList.add(gb);
	europeList.add(ice);
	europeList.add(ne);
	europeList.add(s);
	europeList.add(se);
	europeList.add(u);
	europeList.add(we);
	europewithTerr = new continent("Europe",europeList);
	this.europewithTerr.setContinentValue(5);
	
	List<territory> naList = new ArrayList<territory>(9);
	territory al = new territory("Alaska");
	territory alb = new territory("Alberta");
	territory ca = new territory("Central America");
	territory eus = new territory("Eastern U.S.");
	territory gl = new territory("Greenland");
	territory nt = new territory("Northwest Territory");
	territory o = new territory("Ontario");
	territory q = new territory("Quebec");
	territory wus = new territory("Western U.S.");
	naList.add(al);
	naList.add(alb);
	naList.add(ca);
	naList.add(eus);
	naList.add(gl);
	naList.add(nt);
	naList.add(o);
	naList.add(q);
	naList.add(wus);
	nawithTerr = new continent("North America",naList);
	this.nawithTerr.setContinentValue(5);
	
	List<territory> asiaList = new ArrayList<territory>(12);
	territory af = new territory("Afghanistan");
	territory ch = new territory("China");
	territory in = new territory("India");
	territory irk = new territory("Irkutsk");
	territory j = new territory("Japan");
	territory kam = new territory("Kamchatka");
	territory me = new territory("Middle East");
	territory mon = new territory("Mongolia");
	territory si = new territory("Siam");
	territory sib = new territory("Siberia");
	territory ur = new territory("Ural");
	territory ya = new territory("Yakutsk");
	asiaList.add(af);
	asiaList.add(ch);
	asiaList.add(in);
	asiaList.add(irk);
	asiaList.add(j);
	asiaList.add(kam);
	asiaList.add(me);
	asiaList.add(mon);
	asiaList.add(si);
	asiaList.add(sib);
	asiaList.add(ur);
	asiaList.add(ya);
	asiawithTerr = new continent("Asia",asiaList);
	this.asiawithTerr.setContinentValue(7);
	
	List<territory> saList = new ArrayList<territory>(4);
	territory ar = new territory("Argentina");
	territory br = new territory("Brazil");
	territory pe = new territory("Peru");
	territory ven = new territory("Venezuela");
	saList.add(ar);
	saList.add(br);
	saList.add(pe);
	saList.add(ven);
	sawithTerr = new continent("South America",saList);
	this.sawithTerr.setContinentValue(2);
	
	List<territory> afrList = new ArrayList<territory>(6);
	territory co = new territory("Congo");
	territory ea = new territory("East Africa");
	territory egy = new territory("Egypt");
	territory mad = new territory("Madagascar");
	territory nafr = new territory("North Africa");
	territory safr = new territory("South Africa");
	afrList.add(co);
	afrList.add(ea);
	afrList.add(egy);
	afrList.add(mad);
	afrList.add(nafr);
	afrList.add(safr);
	afrwithTerr = new continent("Africa",afrList);
	this.afrwithTerr.setContinentValue(3);

	List<territory> ausList = new ArrayList<territory>(4);
	territory eaus = new territory("Eastern Australia");
	territory ind = new territory("Indonesia");
	territory ng = new territory("New Guinea");
	territory wa = new territory("Western Australia");
	ausList.add(eaus);
	ausList.add(ind);
	ausList.add(ng);
	ausList.add(wa);
	auswithTerr = new continent("Australia",ausList);
	this.auswithTerr.setContinentValue(2);
	
	//METHODS
	}
	
	
}
