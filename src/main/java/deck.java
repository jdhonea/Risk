import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class deck {
    //Would use a deque, but shuffling is important and Collections.shuffle cannot be used on a Deque
    private List<card> deck = new ArrayList<card>(); //Stores the deck of cards
    private List<card> discarded = new ArrayList<card>(); //Stores the discarded cards traded in
    private int setsTradedIn = 0;


    public deck(int numOfTerritories){
        //TODO Deck generation based on numOfTerritories + 3 wild cards
        //generates the 3 wild cards
        for (int n = 0; n < 3; n++){
            card currentCard = new card('w', "wild");
            deck.add(currentCard);
        } //ends for
        //Generates rest of the deck
        initializeDeck();
        //randomizes the deck order
        Collections.shuffle(deck);
    }//ends constructor

    //returns the number of cards left in the deck
    public int cardsInDeck(){
        return this.deck.size();
    }//ends cardsInDeck

    //returns the card in the first position of the deck and removes it
    public card drawCard(){
        card currentCard  = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }//ends drawCard

    //Accepts a sublist of the players hand as cards traded in and returns the number of armies the player is awarded
    public int cardsTradedIn(List<card> tradedIn){
        int count = 0; //stores the count of the design
        char first = 'n'; // stores the first design of the sublist unless it is a wild card
        //checks for a complete set
        for (card n : tradedIn) {
            if (n.getDesign() == 'w') {
                count++;
            }
            else if (first == 'n') {
                first = n.getDesign();
                count++;
            }
            else if (first == n.getDesign()) {
                count++;
            }
            this.discarded.add(n);
            //tradedIn.remove(n);
        }
        if (count == 3){
            setsTradedIn+=1;
            //System.out.println((setsTradedIn-1)*2+4);
            if(setsTradedIn >= 1 && setsTradedIn < 6)
                return ((setsTradedIn - 1) * 2 + 4);
            else if(setsTradedIn == 6)
                return 15;
            else if(setsTradedIn >= 7)
                return ((setsTradedIn - 6) * 5 + 15);
        }
        return 0;
    }

    //Adds a discarded / traded in card to the discarded List
    public void discardCard(card discardedCard){
        this.discarded.add(discardedCard);
    }//ends discardCard

    //Finishes creating the deck from the offical Risk deck
    private void initializeDeck(){
        card af = new card('c', "Afghanistan");
        card al = new card('i', "Alaska");
        card alb = new card('c', "Alberta");
        card ar = new card('i', "Argentina");
        card br = new card('a', "Brazil");
        card ca = new card('i', "Central Africa");
        card cam = new card('a', "Central America");
        card ch = new card('i', "China");
        card ea = new card('i', "East Africa");
        card eau = new card('a', "Eastern Australia");
        card ec = new card('c', "Eastern Canada");
        card eus = new card('a', "Eastern United States");
        card eg = new card('i', "Egypt");
        card gb = new card('a', "Great Britain");
        card gr = new card('c', "Greenland");
        card ic = new card('i', "Iceland");
        card indi = new card('c', "India");
        card indo = new card('a', "Indonesia");
        card ir = new card('c', "Irkutsk");
        card ja = new card('a', "Japan");
        card ka = new card('i', "Kamchatka");
        this.deck.add(af);
        this.deck.add(al);
        this.deck.add(alb);
        this.deck.add(ar);
        this.deck.add(br);
        this.deck.add(ca);
        this.deck.add(cam);
        this.deck.add(ch);
        this.deck.add(ea);
        this.deck.add(eau);
        this.deck.add(ec);
        this.deck.add(eus);
        this.deck.add(eg);
        this.deck.add(gb);
        this.deck.add(gr);
        this.deck.add(ic);
        this.deck.add(indi);
        this.deck.add(indo);
        this.deck.add(ir);
        this.deck.add(ja);
        this.deck.add(ka);
        card ma = new card('c', "Madagascar");
        card me = new card('i', "Middle East");
        card mo = new card('i', "Mongolia");
        card ne = new card('i', "New Guinea");
        card na = new card('c', "North Africa");
        card neu = new card('a', "Northern Europe");
        card nw = new card('a', "Northwest Territory");
        card on = new card('c', "Ontario");
        card pe = new card('i', "Peru");
        card ru = new card('c', "Russia");
        card sc = new card('c', "Scandinavia");
        card si = new card('c', "Siberia");
        card sa = new card('a', "South Africa");
        card sea = new card('i', "Southeast Asia");
        card se = new card('a', "Southern Europe");
        this.deck.add(ma);
        this.deck.add(me);
        this.deck.add(mo);
        this.deck.add(ne);
        this.deck.add(na);
        this.deck.add(neu);
        this.deck.add(nw);
        this.deck.add(on);
        this.deck.add(pe);
        this.deck.add(ru);
        this.deck.add(sc);
        this.deck.add(si);
        this.deck.add(sa);
        this.deck.add(sea);
        this.deck.add(se);
        card ur = new card('c', "Ural");
        card ve = new card('i', "Venezuela");
        card wa = new card('a', "Western Australia");
        card we = new card('a', "Western Europe");
        card wus = new card('a', "Western United States");
        card ya = new card('c', "Yakutsk");
        this.deck.add(ur);
        this.deck.add(ve);
        this.deck.add(wa);
        this.deck.add(we);
        this.deck.add(wus);
        this.deck.add(ya);
    }//ends initializeDeck

}//ends class deck
