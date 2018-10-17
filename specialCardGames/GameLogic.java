
package specialCardGames;

/**********************************************************************
 * @author Jarod Collier, Maz Ashgar, Josh Lowell
 * @version 9/28/2018
 *
 *********************************************************************/
public class GameLogic{
	
	private Deck deck;
	
	private int score;
	
	/******************************************************************
	 * Initializes the variables for the game logic 
	 *****************************************************************/
	public GameLogic() {
		
		deck = new Deck();
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
	 * The first "level" of the game, checks if the randomly chosen
	 * card has the same color as the players choice
	 * @param color - The player input of red or black in integer form
	 *                 in order to match the Deck class
	 *****************************************************************/
	public void redVsBlackScore(int color) {
		//TODO Change this

		// Checks if correct
		if (deck.blackOrRed() == color) {
			score++;
			//return ;
		}
		else {
			score--;
		}
		deck.chooseCard();
	}

	/******************************************************************
	 * The second "level" of the game, checks if the player correctly
	 * guessed if the next card is higher or lower than the next card
	 * @param loh - The player input of lower or higher in integer
	 *               form in order to match the Deck class
	 *****************************************************************/
	public void lowerOrHigherScore(int loh){
		if(loh == deck.lowerOrHigher()){
			score -= 2;
		}
		else{
			score += 2;
		}

		deck.chooseCard();
	}

	/******************************************************************
	 * The third "level" of the game, checks if the player correctly
	 * guessed if the next card is in-between the previous two cards
	 * @param ioo - The player input of inside or outside in integer
	 *              form in order to match the Deck class
	 *****************************************************************/
	public void insideOrOutsideScore(int ioo){
		if(ioo == deck.insideOrOutside()){
			score -= 3;
		}
		else{
			score += 3;
		}

		deck.chooseCard();
	}

	/******************************************************************
	 * The fourth "level" of the game, checks if the randomly chosen
	 * card has the same suit as the players choice
	 * @param suit - The player input of the suit in integer form in
	 *                order to match the Deck class
	 *****************************************************************/
	public void guessSuitScore(int suit){
		if(deck.guessSuit(suit)){
			score -= 4;
		}
		else{
			score += 4;
		}

		deck.chooseCard();
	}

	/******************************************************************
	 * The fifth "level" of the game, checks if the randomly chosen
	 * card has the same value as the players choice
	 * @param value - The player input of a card value guess
	 *****************************************************************/
	public void guessCardValueScore(int value){
		//TODO Change value
		if(deck.guessCard(value)){
			score -= 1;
		}
		else{
			score += 10;
		}

		deck.chooseCard();
	}/******************************************************************
	 * The final "level" of the game, riding the bus. This method will
	 * be repeatedly called by the gui, if the player picks a face card
	 * they have to re-ride the bus. This just checks if the
	 *****************************************************************/
	public void checkFaceCardScore(int card){
		if(deck.checkFaceCard()){

		}
		else{
			score =
		}
	}
}
