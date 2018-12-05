package specialCardGames;

import org.junit.Before;

import static org.junit.Assert.*;

public class GameLogicTest {
    /******************************************************************
     * This test is meant to test the getScore method. The test is
     * checking a small positive score.
     *****************************************************************/
    @org.junit.Test
    public void shouldGetScore1() {
        GameLogic gg = new GameLogic();
        gg.setScore(1);
        assertEquals(1,gg.getScore());

    }
    /******************************************************************
     * This test is meant to test the getScore method. The test is
     * checking a score of 0.
     *****************************************************************/
    @org.junit.Test
    public void shouldGetScore2() {
        GameLogic gg = new GameLogic();
        gg.setScore(0);
        assertEquals(0,gg.getScore());

    }
    /******************************************************************
     * This test is meant to test the getScore method. The test is
     * checking a small negative score.
     *****************************************************************/
    @org.junit.Test
    public void shouldGetScore3() {
        GameLogic gg = new GameLogic();
        gg.setScore(-1);
        assertEquals(-1,gg.getScore());

    }
    /******************************************************************
     * This test is meant to test the getScore method. The test is
     * checking a large positive score.
     *****************************************************************/
    @org.junit.Test
    public void shouldGetScore4() {
        GameLogic gg = new GameLogic();
        gg.setScore(42069);
        assertEquals(42069,gg.getScore());

    }
    /******************************************************************
     * This test is meant to test the getScore method. The test is
     * checking a large negative score.
     *****************************************************************/
    @org.junit.Test
    public void shouldGetScore5() {
        GameLogic gg = new GameLogic();
        gg.setScore(-42069);
        assertEquals(-42069,gg.getScore());

    }
    /******************************************************************
     * This test is meant to test the redVsBlackScore method. The test
     * is checking the path of a correctly identified black card.
     *****************************************************************/
    @org.junit.Test
    public void testRedVsBlackScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.redVsBlackScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5S.png","black"));
    }
    /******************************************************************
     * This test is meant to test the redVsBlackScore method. The test
     * is checking the path of a correctly identified red card.
     *****************************************************************/
    @org.junit.Test
    public void testRedVsBlackScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.redVsBlackScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5H.png","red"));
    }
    /******************************************************************
     * This test is meant to test the redVsBlackScore method. The test
     * is checking the path of an incorrectly identified black card.
     *****************************************************************/
    @org.junit.Test
    public void testRedVsBlackScore3() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.redVsBlackScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5S.png","red"));
    }
    /******************************************************************
     * This test is meant to test the redVsBlackScore method. The test
     * is checking the path of an incorrectly identified red card.
     *****************************************************************/
    @org.junit.Test
    public void testRedVsBlackScore4() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.redVsBlackScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5H.png","black"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of a correctly identified spade.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5S.png","spades"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of a correctly identified heart.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5H.png","hearts"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of a correctly identified club.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5C.png","clubs"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of a correctly identified diamond.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5D.png", "diamonds"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of an incorrectly identified spade.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore5() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5S.png", "clubs"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of an incorrectly identified heart.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore6() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5H.png", "spades"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of an incorrectly identified club.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore7() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5C.png", "diamonds"));
    }
    /******************************************************************
     * This test is meant to test the guessSuitScore method. The test
     * is checking the path of an incorrectly identified diamond.
     *****************************************************************/
    @org.junit.Test
    public void testGuessSuitScore8() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5D.png", "hearts"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified ace.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/AD.png","ace"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 2.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/2C.png","2"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 3.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/3H.png","3"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 4.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/4S.png","4"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 5.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore5() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5D.png","5"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 6.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore6() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/6C.png","6"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 7.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore7() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/7H.png","7"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 8.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore8() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/8S.png","8"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 9.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore9() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/9D.png","9"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified 10.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore10() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/10C.png","10"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified jack.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore11() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/JH.png","jack"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified queen.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore12() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/QS.png","queen"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of a correctly identified king.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore13() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/KD.png","king"));
    }
    /******************************************************************
     * This test is meant to test the guessCardValueScore method. The
     * test is checking the path of an incorrectly identified card.
     *****************************************************************/
    @org.junit.Test
    public void testGuessCardValueScore14() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessCardValueScore("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/AD.png","king"));
    }
    /******************************************************************
     * This test is meant to test the checkPathFaceScore method. The
     * test is checking to see if the card is an Ace.
     *****************************************************************/
    @org.junit.Test
    public void testCheckPathFaceScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/AD.png"));
    }
    /******************************************************************
     * This test is meant to test the checkPathFaceScore method. The
     * test is checking to see if the card is a Jack.
     *****************************************************************/
    @org.junit.Test
    public void testCheckPathFaceScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/JS.png"));
    }
    /******************************************************************
     * This test is meant to test the checkPathFaceScore method. The
     * test is checking to see if the card is a Queen.
     *****************************************************************/
    @org.junit.Test
    public void testCheckPathFaceScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/QC.png"));
    }
    /******************************************************************
     * This test is meant to test the checkPathFaceScore method. The
     * test is checking to see if the card is a King.
     *****************************************************************/
    @org.junit.Test
    public void testCheckPathFaceScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/KH.png"));
    }
    /******************************************************************
     * This test is meant to test the checkPathFaceScore method. The
     * test is checking to see if the card is not a face card.
     *****************************************************************/
    @org.junit.Test
    public void testCheckPathFaceScore5() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.checkPathFaceCard("file:/Users/joshlowell/" +
                "Desktop/350/CIS-350-Project/out/production/" +
                "CIS-350-Project/specialCardGames/cardImages/" +
                "big/5D.png"));
    }

}