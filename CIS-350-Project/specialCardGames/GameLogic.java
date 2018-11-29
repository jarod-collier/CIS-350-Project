
package specialCardGames;

/**********************************************************************
 * @author Jarod Collier, Maz Ashgar, Josh Lowell
 * @version 9/28/2018
 *
 *********************************************************************/
public class GameLogic {

    private Deck deck;

    private int score;

    /******************************************************************
     * Initializes the variables for the game logic for the first phase
     *****************************************************************/
    public GameLogic() {

        deck = new Deck();

        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            deck.chooseCard();

        score = 0;

    }

    /******************************************************************
     * @return the score
     *****************************************************************/
    public int getScore() {
        return score;
    }

    /******************************************************************
     * @param score the score to set
     *****************************************************************/
    public void setScore(int score) {
        this.score = score;
    }

    /******************************************************************
     * This method is to help the GamePanel call the right .png file
     * when a card is chosen. It matches the names of the files in
     * our cardImages file for small images
     * @param valueFromBack - how far back in the deck to look
     * @return The file's name
     *****************************************************************/
    public String smallCardString(int valueFromBack) {
        String card = "cardImages/small/";
        if (deck.getSuitFromBack(valueFromBack) == 0) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "S";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "S";
            }
        } else if (deck.getSuitFromBack(valueFromBack) == 1) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "H";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "H";
            }
        } else if (deck.getSuitFromBack(valueFromBack) == 2) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "C";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "C";
            }
        } else {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "D";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "D";
            }
        }
        return card + ".png";
    }

    /******************************************************************
     * This method is to help the GamePanel call the right .png file
     * when a card is chosen. It matches the names of the files in
     * our cardImages file for small images
     * @param valueFromBack - how far back in the deck to look
     * @return The file's name
     *****************************************************************/
    public String bigCardString(int valueFromBack) {
        String card = "cardImages/big/";
        if (deck.getSuitFromBack(valueFromBack) == 0) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "S";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "S";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "S";
            }
        } else if (deck.getSuitFromBack(valueFromBack) == 1) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "H";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "H";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "H";
            }
        } else if (deck.getSuitFromBack(valueFromBack) == 2) {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "C";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "C";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "C";
            }
        } else {
            if (deck.getCardFromBack(valueFromBack) == 11) {
                card += "J" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 12) {
                card += "Q" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 13) {
                card += "K" + "D";
            } else if (deck.getCardFromBack(valueFromBack) == 14) {
                card += "A" + "D";
            } else {
                card += deck.getCardFromBack(valueFromBack) + "D";
            }
        }
        return card + ".png";
    }

    /******************************************************************
     * The first "level" of the game, checks if the randomly chosen
     * card has the same color as the players choice
     * @param guess - The player's guess is either true or false
     *****************************************************************/
    public void redVsBlackScore(boolean guess) {

        // Checks if correct
        if (guess) {
            score--;
            //return ;
        } else {
            score++;
        }
    }

    /******************************************************************
     * The second "level" of the game, checks if the player correctly
     * guessed if the next card is higher or lower than the next card
     * @param loh - The player input of lower or higher in integer
     *               form in order to match the Deck class
     *****************************************************************/
    public boolean lowerOrHigherScore(int loh) {

        //variable to return the decision
        boolean decision;

        if (loh == deck.lowerOrHigher()) {
            score -= 2;
            //the user's choice is correct
            decision = true;
        } else {
            score += 2;
            //the user's choice is incorrect
            decision = false;
        }
        return decision;
    }

    /******************************************************************
     * The third "level" of the game, checks if the player correctly
     * guessed if the next card is in-between the previous two cards
     * @param ioo - The player input of inside or outside in integer
     *              form in order to match the Deck class
     *****************************************************************/
    public boolean insideOrOutsideScore(int ioo) {

        boolean decision;
        if (ioo == deck.insideOrOutside()) {
            score -= 3;
            decision = true;
        } else {
            score += 3;
            decision = false;
        }

        return decision;
    }

    /******************************************************************
     * The fourth "level" of the game, checks if the randomly chosen
     * card has the same suit as the players choice
     * @param guess - The player's guess is either true or false
     *****************************************************************/
    public void guessSuitScore(boolean guess) {
        if (guess) {
            score -= 4;
        } else {
            score += 4;
        }
    }

    /******************************************************************
     * The fifth "level" of the game, checks if the randomly chosen
     * card has the same value as the players choice
     * @param value - The player input of a card value guess
     *****************************************************************/
    public void guessCardValueScore(int value) {
        //TODO Change value
        if (deck.guessCard(value)) {
            score -= 1;
        } else {
            score += 10;
        }
    }

    /******************************************************************
     * Checks the path of the pictures if they are a face card
     * @param path - the path of the card
     * @return true or false whether the card is a face card
     *****************************************************************/
    public boolean checkPathFaceCard(String path) {

        String cardPath[] = path.split("/");

        String ending = cardPath[cardPath.length - 1];

        System.out.println(ending);

        // Gets the cards value from the path
        char cardValue = (ending.charAt(0));

        System.out.println(cardValue);

        // Checks if the card value is a face card, if it is change the score
        if (cardValue == 'J') {
            score += 1;
            return true;
        } else if (cardValue == 'Q') {
            score += 2;
            return true;
        } else if (cardValue == 'K') {
            score += 3;
            return true;
        } else if (cardValue == 'A') {
            score += 4;
            return true;
        } else {
            return false;
        }
    }

    /******************************************************************
     * Creates another deck for the second phase of the game
     *****************************************************************/
    public void createNewDeck() {
        deck = new Deck();

        for (int amountOfCards = 0; amountOfCards < 52; amountOfCards++)
            deck.chooseCard();
    }
}
