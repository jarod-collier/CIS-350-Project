
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
	 * our cardImages file
	 * @return  The file's name
	 *****************************************************************/
	public String cardString(int valueFromBack){
		String card = "cardImages/small/";
		if(deck.getSuitFromBack(valueFromBack)==0){
			if(deck.getCardFromBack(valueFromBack) == 11){
				card += "J" + "S";
			}
			else if(deck.getCardFromBack(valueFromBack) == 12){
				card += "Q" + "S";
			}
			else if(deck.getCardFromBack(valueFromBack) == 13){
				card += "K" + "S";
			}
			else if(deck.getCardFromBack(valueFromBack) == 14){
				card += "A" + "S";
			}
			else{
				card += deck.getCardFromBack(valueFromBack) + "S";
			}
		}
		else if(deck.getSuitFromBack(valueFromBack) == 1){
			if(deck.getCardFromBack(valueFromBack) == 11){
				card += "J" + "H";
			}
			else if(deck.getCardFromBack(valueFromBack) == 12){
				card += "Q" + "H";
			}
			else if(deck.getCardFromBack(valueFromBack) == 13){
				card += "K" + "H";
			}
			else if(deck.getCardFromBack(valueFromBack) == 14){
				card += "A" + "H";
			}
			else{
				card += deck.getCardFromBack(valueFromBack) + "H";
			}
		}
		else if(deck.getSuitFromBack(valueFromBack) == 2){
			if(deck.getCardFromBack(valueFromBack) == 11){
				card += "J" + "C";
			}
			else if(deck.getCardFromBack(valueFromBack) == 12){
				card += "Q" + "C";
			}
			else if(deck.getCardFromBack(valueFromBack) == 13){
				card += "K" + "C";
			}
			else if(deck.getCardFromBack(valueFromBack) == 14){
				card += "A" + "C";
			}
			else{
				card += deck.getCardFromBack(valueFromBack) + "C";
			}
		}
		else{
			if(deck.getCardFromBack(valueFromBack) == 11){
				card += "J" + "D";
			}
			else if(deck.getCardFromBack(valueFromBack) == 12){
				card += "Q" + "D";
			}
			else if(deck.getCardFromBack(valueFromBack) == 13){
				card += "K" + "D";
			}
			else if(deck.getCardFromBack(valueFromBack) == 14){
				card += "A" + "D";
			}
			else{
				card += deck.getCardFromBack(valueFromBack) + "D";
			}
		}
		return card + ".png";
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
        //deck.chooseCard(); <<<< TODO: this breaks the code
	}

	/******************************************************************
	 * The second "level" of the game, checks if the player correctly
	 * guessed if the next card is higher or lower than the next card
	 * @param loh - The player input of lower or higher in integer
	 *               form in order to match the Deck class
	 *****************************************************************/
	public boolean lowerOrHigherScore(int loh){

	    //variable to return the decision
		boolean decision;

		if(loh == deck.lowerOrHigher()){
			score -= 2;
			//the user's choice is correct
			decision = true;
		}
		else{
			score += 2;
			//the user's choice is incorrect
			decision = false;
		}

		//deck.chooseCard(); <<<< TODO: this breaks the code
 		return decision;
	}

	/******************************************************************
	 * The third "level" of the game, checks if the player correctly
	 * guessed if the next card is in-between the previous two cards
	 * @param ioo - The player input of inside or outside in integer
	 *              form in order to match the Deck class
	 *****************************************************************/
	public boolean insideOrOutsideScore(int ioo){

	    boolean decision;
		if(ioo == deck.insideOrOutside()){
			score -= 3;
			decision = true;
		}
		else{
			score += 3;
			decision = false;
		}

        //deck.chooseCard(); <<<< TODO: this breaks the code
		return decision;
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

        //deck.chooseCard(); <<<< TODO: this breaks the code
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

        //deck.chooseCard(); <<<< TODO: this breaks the code
	}
//	/******************************************************************
//	 * The final "level" of the game, riding the bus. This method will
//	 * be repeatedly called by the gui, if the player picks a face card
//	 * they have to re-ride the bus. This just checks if the
//	 *****************************************************************/
//	public void checkFaceCardScore(int card){
//		if(deck.checkFaceCard()){
//
//		}
//		else{
//			score =
//		}
//	}
}
