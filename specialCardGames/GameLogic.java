
package specialCardGames;

/**********************************************************************
 * @author Jarod Collier, Maz Ashgar, Josh Lowell
 * @version 9/28/2018
 *
 *********************************************************************/
public class GameLogic{
	
	private Deck deck;
	
	private int score, difference;


	
//	public static void main(String[] args) {
//
//	}

	/******************************************************************
	 * Initializes the variables for the game logic 
	 *****************************************************************/
	public GameLogic() {
		
		deck = new Deck();
		
		score = 0;
		difference = 0;

		
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
	 * @return the difference
	 *****************************************************************/
	public int getDifference() {
		return difference;
	}

	/******************************************************************
	 * @param difference the difference to set
	 *****************************************************************/
	public void setDifference(int difference) {
		this.difference = difference;
	}

	/******************************************************************
	 * The first "level" of the game, checks if the randomly chosen
	 * card has the same color as the players choice
	 *****************************************************************/
	public void redVsBlackScore(int suit) {
		//TODO Change this

		int color;
		// If the card is a spade or club, it's black, so return 0
		if (suit == 0 || suit == 2)
			color = 0;
		else
			color = 1;
		if(deck.blackOrRed(69) == color){
			score = score - 1;
		}
		else{
			score = score + 1;
		}
	}

	/******************************************************************
	 * The second "level" of the game, checks if the player correctly
	 * guessed if the next card is higher or lower than the next card
	 *****************************************************************/
	public void lowerOrHigherScore(int loh){
		if(loh == deck.lowerOrHigher()){
			score = score - 2;
		}
		else{
			score = score + 2;
		}
	}

	/******************************************************************
	 * The third "level" of the game, checks if the player correctly
	 * guessed if the next card is in-between the previous two cards
	 *****************************************************************/
	public void insideOrOutsideScore(int ioo){
		if(ioo == deck.insideOrOutside()){
			score = score -3;
		}
		else{
			score = score + 3;
		}
	}

	/******************************************************************
	 * The fourth "level" of the game, checks if the randomly chosen
	 * card has the same suit as the players choice
	 *****************************************************************/
	public void guessSuitScore(int suit){
		if(deck.guessSuit(suit)){
			score = score - 4;
		}
		else{
			score = score + 4;
		}
	}

	/******************************************************************
	 * The fifth "level" of the game, checks if the randomly chosen
	 * card has the same value as the players choice
	 *****************************************************************/
	public void guessCardValueScore(int value){
		//TODO Change value
		if(value == 0){
			score = score - 10;
		}
		else{
			score = score + 10;
		}
	}
}
