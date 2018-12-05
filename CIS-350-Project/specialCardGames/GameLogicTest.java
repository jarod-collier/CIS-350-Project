package specialCardGames;

import org.junit.Before;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Before
    public void init(){

    }

    @org.junit.Test
    public void shouldGetScore1() {
        GameLogic gg = new GameLogic();
        gg.setScore(1);
        assertEquals(1,gg.getScore());

    }

    @org.junit.Test
    public void shouldGetScore2() {
        GameLogic gg = new GameLogic();
        gg.setScore(0);
        assertEquals(0,gg.getScore());

    }

    @org.junit.Test
    public void shouldGetScore3() {
        GameLogic gg = new GameLogic();
        gg.setScore(-1);
        assertEquals(-1,gg.getScore());

    }

    @org.junit.Test
    public void shouldGetScore4() {
        GameLogic gg = new GameLogic();
        gg.setScore(42069);
        assertEquals(42069,gg.getScore());

    }

    @org.junit.Test
    public void shouldGetScore5() {
        GameLogic gg = new GameLogic();
        gg.setScore(-42069);
        assertEquals(-42069,gg.getScore());

    }

    @org.junit.Test
    public void testRedVsBlackScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.redVsBlackScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5S.png","black"));
    }
    @org.junit.Test
    public void testRedVsBlackScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.redVsBlackScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5H.png","red"));
    }
    @org.junit.Test
    public void testRedVsBlackScore3() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.redVsBlackScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5S.png","red"));
    }
    @org.junit.Test
    public void testRedVsBlackScore4() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.redVsBlackScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5H.png","black"));
    }

    @org.junit.Test
    public void testGuessSuitScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5S.png","spades"));
    }
    @org.junit.Test
    public void testGuessSuitScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5H.png","hearts"));
    }
    @org.junit.Test
    public void testGuessSuitScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5C.png","clubs"));
    }
    @org.junit.Test
    public void testGuessSuitScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5D.png", "diamonds"));
    }
    @org.junit.Test
    public void testGuessSuitScore5() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5S.png", "clubs"));
    }
    @org.junit.Test
    public void testGuessSuitScore6() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5H.png", "spades"));
    }
    @org.junit.Test
    public void testGuessSuitScore7() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5C.png", "diamonds"));
    }
    @org.junit.Test
    public void testGuessSuitScore8() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessSuitScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5D.png", "hearts"));
    }

    @org.junit.Test
    public void testGuessCardValueScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/AD.png","ace"));
    }
    @org.junit.Test
    public void testGuessCardValueScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/2C.png","2"));
    }
    @org.junit.Test
    public void testGuessCardValueScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/3H.png","3"));
    }
    @org.junit.Test
    public void testGuessCardValueScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/4S.png","4"));
    }
    @org.junit.Test
    public void testGuessCardValueScore5() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5D.png","5"));
    }
    @org.junit.Test
    public void testGuessCardValueScore6() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/6C.png","6"));
    }
    @org.junit.Test
    public void testGuessCardValueScore7() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/7H.png","7"));
    }
    @org.junit.Test
    public void testGuessCardValueScore8() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/8S.png","8"));
    }
    @org.junit.Test
    public void testGuessCardValueScore9() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/9D.png","9"));
    }
    @org.junit.Test
    public void testGuessCardValueScore10() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/10C.png","10"));
    }
    @org.junit.Test
    public void testGuessCardValueScore11() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/JH.png","jack"));
    }
    @org.junit.Test
    public void testGuessCardValueScore12() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/QS.png","queen"));
    }
    @org.junit.Test
    public void testGuessCardValueScore13() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/KD.png","king"));
    }
    @org.junit.Test
    public void testGuessCardValueScore14() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/AD.png","ace"));
    }
    @org.junit.Test
    public void testGuessCardValueScore15() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.guessCardValueScore("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/AD.png","king"));
    }
    @org.junit.Test
    public void testCheckPathFaceScore1() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/AD.png"));
    }
    @org.junit.Test
    public void testCheckPathFaceScore2() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/JS.png"));
    }
    @org.junit.Test
    public void testCheckPathFaceScore3() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/QC.png"));
    }
    @org.junit.Test
    public void testCheckPathFaceScore4() {
        GameLogic gg = new GameLogic();
        assertTrue(gg.checkPathFaceCard("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/KH.png"));
    }
    @org.junit.Test
    public void testCheckPathFaceScore5() {
        GameLogic gg = new GameLogic();
        assertFalse(gg.checkPathFaceCard("file:/Users/joshlowell/Desktop/350/CIS-350-Project/out/production/CIS-350-Project/specialCardGames/cardImages/big/5D.png"));
    }

}