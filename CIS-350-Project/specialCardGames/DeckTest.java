package specialCardGames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCardFromBack1() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getCardFromBack(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCardFromBack2() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getCardFromBack(53);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSuitFromBack1() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getSuitFromBack(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSuitFromBack2() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getSuitFromBack(53);
    }
    @Test(expected = IllegalArgumentException.class)
    public void chooseCard() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.chooseCard();
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void lowerOrHigher() {
        Deck d = new Deck();
        d.chooseCard();
        d.lowerOrHigher();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insideOrOutside() {
        Deck d = new Deck();
        d.chooseCard();
        d.chooseCard();
        d.insideOrOutside();
    }

    @Test
    public void emptyDeck1() {
        Deck d = new Deck();
        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();
        assertTrue(d.emptyDeck());
    }
    @Test
    public void emptyDeck2() {
        Deck d = new Deck();
        assertFalse(d.emptyDeck());
    }

}