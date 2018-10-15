import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class deckTest {
    @Test
    public void nonmatchingSet(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('i', "TEST");
        card card3 = new card('i', "TEST");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(0, deck.cardsTradedIn(tradedIn));

    }

    @Test
    public void oneOfEach(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('i', "TEST");
        card card3 = new card('c', "TEST");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(4, deck.cardsTradedIn(tradedIn));

    }

    @Test
    public void oneOfEachWild(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('i', "TEST");
        card card3 = new card('w', "TEST");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(4, deck.cardsTradedIn(tradedIn));

    }

    @Test
    public void matchingSet(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('a', "TEST");
        card card3 = new card('w', "TESTWILD");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(4, deck.cardsTradedIn(tradedIn));

    }
    @Test
    public void tripleWildMatchingSet(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('w', "TEST");
        card card2 = new card('w', "TEST");
        card card3 = new card('w', "TESTWILD");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(4, deck.cardsTradedIn(tradedIn));

    }
    @Test
    public void tripleMatchingSet(){
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('i', "TEST");
        card card2 = new card('i', "TEST");
        card card3 = new card('i', "TESTWILD");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        deck deck = new deck(42);
        assertEquals(4, deck.cardsTradedIn(tradedIn));

    }
    @Test
    public void multipleMatchingSetLessThan6(){
        deck deck = new deck(42);
        for (int n = 1; n < 6; n++) {
            List<card> tradedIn = new ArrayList<card>();
            card card1 = new card('a', "TEST");
            card card2 = new card('a', "TEST");
            card card3 = new card('w', "TESTWILD");
            tradedIn.add(card1);
            tradedIn.add(card2);
            tradedIn.add(card3);
            //System.out.println(((n-1) * 2 + 4));
            assertEquals(((n-1) * 2 + 4), deck.cardsTradedIn(tradedIn));
        }
    }
    @Test
    public void sixMatchingSet(){
        deck deck = new deck(42);
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('a', "TEST");
        card card3 = new card('w', "TESTWILD");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        for (int n = 1; n < 6; n++) {
            //System.out.println(((n-1) * 2 + 4));
            deck.cardsTradedIn((tradedIn));

        }
        assertEquals(15, deck.cardsTradedIn(tradedIn));
    }
    @Test
    public void moreThanSixMatchingSet(){
        deck deck = new deck(42);
        List<card> tradedIn = new ArrayList<card>();
        card card1 = new card('a', "TEST");
        card card2 = new card('a', "TEST");
        card card3 = new card('w', "TESTWILD");
        tradedIn.add(card1);
        tradedIn.add(card2);
        tradedIn.add(card3);
        for (int n = 1; n <= 15; n++) {
            //System.out.println(((n-1) * 2 + 4));
            if(n > 6)
                assertEquals(((n - 6) * 5 + 15), deck.cardsTradedIn(tradedIn));
            else
                deck.cardsTradedIn((tradedIn));
        }

    }
    
    @Test
    public void cardsInDeckTest(){
        deck deck = new deck(42);
        assertEquals(deck.cardsInDeck(),45);  
    }
    
    @Test
    public void drawCardTest(){
        deck deck = new deck(42);
        deck.drawCard();
        assertEquals(deck.cardsInDeck(),44);  
    }

    @Test
    public void discardCardTest(){
        deck deck = new deck(42);
        card testCard = new card('i',"Egypt");
        deck.discardCard(testCard);
        assertEquals(deck.discarded.get(0),testCard);  
    }
}
