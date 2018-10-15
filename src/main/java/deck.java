import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains the deck, traded in cards, and also handles the manipulation of the deck needed for a game of Risk.
 */

public class deck implements Serializable{
    //Would use a deque, but shuffling is important and Collections.shuffle cannot be used on a Deque
    public List<card> deck = new ArrayList<card>(); //Stores the deck of cards
    public List<card> discarded = new ArrayList<card>(); //Stores the discarded cards traded in
    public int setsTradedIn = 0;

    /**
     * Deck constructor, reads the number of territories and creates a deck of that size. Was initially going to be randomly generated,
     * but instead had the cards hard-coded in.
     * @param numOfTerritories The number of territories in the map which will equate to the number of cards in the initial deck
     */
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

    /**
     * Returns the number of cards left in the deck.
     * @return  the size of the deck list
     */
    public int cardsInDeck(){
        return this.deck.size();
    }//ends cardsInDeck

    /**
     * Simulates the player drawing the top card of the deck. The top card is drawn and then is removed from the deck list.
     * @return the top card of the deck
     */
    public card drawCard(){
        card currentCard  = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }//ends drawCard

    /**
     * Accepts a list of cards as cards to be traded in and then returns the number of armies to be received based upon the number of previously traded in sets
     * @param tradedIn the list of cards to be traded in
     * @return          number of new armies to be received
     */
    public int cardsTradedIn(List<card> tradedIn){
        boolean setFound;
        setFound = checkForSet(tradedIn);
        if(!setFound){
            setFound = checkForOneEach(tradedIn);
        }
        for(card n : tradedIn){
            this.discarded.add(n);
        }
        if (setFound){
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

    /**
     * Checks a list of card objects for a complete set of cards with 3 matching designs.
     * @param tradedIn the list of cards traded in
     * @return          returns true if a set is found and false if not
     */
    private boolean checkForSet(List<card> tradedIn){
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
            //tradedIn.remove(n);
        }
        if(count == 3)
            return true;
        else
            return false;
    }

    /**
     * Checks the list of card objects for a set of one of each design.
     * @param tradedIn  the list of cards traded in
     * @return          returns true if each design is present in the list of cards and false if not
     */
    private boolean checkForOneEach(List<card> tradedIn){
        int count = 0;
        char first = 'n';
        char second = 'n';
        for(card n : tradedIn){
            if(n.getDesign() == 'w')
                count++;
            else if (first == 'n'){
                first = n.getDesign();
                count++;
            }
            else{
                if(second == 'n' && n.getDesign() != first){
                    count++;
                    second = n.getDesign();
                }
                else if(second != 'n' && n.getDesign() != first && n.getDesign() != second)
                    count++;
            }
        }
        if(count == 3)
            return true;
        else
            return false;
    }

    /**
     * Adds a card to the discarded list of card objects.
     * @param discardedCard card object to be stored in the list of discarded cards
     */
    public void discardCard(card discardedCard){
        this.discarded.add(discardedCard);
    }//ends discardCard

    /**
     * Initializes the deck based upon a deck from the original Risk board game.
     */
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
