import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class deck {
    //Would use a deque, but shuffling is important and Collections.shuffle cannot be used on a Deque
    List<card> deck = new ArrayList<card>(); //Stores the deck of cards
    List<card> discarded = new ArrayList<card>(); //Stores the discarded cards traded in

    public deck(int numOfTerritories){
        //TODO Deck generation based on numOfTerritories + 3 wild cards
        //generates the 3 wild cards
        for (int n = 0; n < 3; n++){
            card currentCard = new card('w', "wild");
            deck.add(currentCard);
        } //ends for
        //Generates rest of the deck
        for (int n = 0; n < numOfTerritories; n++){
            //Needs rest of the deck generation fleshed out
        }//ends for
        //randomizes the deck order
        Collections.shuffle(deck);
    }//ends constructor

    public int cardsInDeck(){
        return this.deck.size();
    }//ends cardsInDeck

    //returns the card in the first position of the deck and removes it
    public card drawCard(){
        card currentCard  = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }//ends drawCard

    //Adds a discarded / traded in card to the discarded List
    public void discardCard(card discardedCard){
        this.discarded.add(discardedCard);
    }//ends discardCard
}//ends class deck
