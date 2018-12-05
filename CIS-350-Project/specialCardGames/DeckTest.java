package specialCardGames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {
    /******************************************************************
     * This test is meant to test the boundary of the getCardFromBack
     * method. The test is asking for the 53rd card that doesn't exist.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCardFromBack1() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getCardFromBack(0);
    }
    /******************************************************************
     * This test is meant to test the boundary of the getCardFromBack
     * method. The test is asking for the 0th card that doesn't exist.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCardFromBack2() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getCardFromBack(53);
    }
    /******************************************************************
     * This test is meant to test the boundary of the getCardFromBack
     * method. The test is asking for the 53rd card that doesn't exist.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSuitFromBack1() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getSuitFromBack(0);
    }
    /******************************************************************
     * This test is meant to test the boundary of the getCardFromBack
     * method. The test is asking for the 0th card that doesn't exist.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSuitFromBack2() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.getSuitFromBack(53);
    }
    /******************************************************************
     * This test is meant to test the boundary of the chooseCard
     * method. The test is trying to draw the 53rd card from 52.
     *****************************************************************/
    @Test(expected = IllegalArgumentException.class)
    public void chooseCard() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();

        d.chooseCard();
    }
    /******************************************************************
     * This test is meant to test the boundary of the lowerOrHigher
     * method. The test is trying to compare 1 card when 2 are needed.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void lowerOrHigher() {
        Deck d = new Deck();
        d.chooseCard();
        d.lowerOrHigher();
    }
    /******************************************************************
     * This test is meant to test the boundary of the insideOrOutside
     * method. The test is trying to compare 2 cards when 3 are needed.
     *****************************************************************/
    @Test(expected = IndexOutOfBoundsException.class)
    public void insideOrOutside() {
        Deck d = new Deck();
        d.chooseCard();
        d.chooseCard();
        d.insideOrOutside();
    }
    /******************************************************************
     * This test is meant to test the boundary of the emptyDeck
     * method. The test is drawing every card and then confirming
     * that the deck is empty.
     *****************************************************************/
    @Test
    public void emptyDeck1() {
        Deck d = new Deck();
        for(int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            d.chooseCard();
        assertTrue(d.emptyDeck());
    }
    /******************************************************************
     * This test is meant to test the boundary of the emptyDeck
     * method. The test is drawing every card and then confirming
     * that the deck is not empty.
     *****************************************************************/
    @Test
    public void emptyDeck2() {
        Deck d = new Deck();
        assertFalse(d.emptyDeck());
    }

}