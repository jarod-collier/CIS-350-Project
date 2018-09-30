
package specialCardGames;

/**********************************************************************
 * @author Jarod Collier, Maz Ashgar, Josh Lowell
 * @version 9/28/2018
 *
 *********************************************************************/
public class GameLogic {
	
	private Deck deck;
	
	private int score, difference;
	
	private int[] tally;

	
	public static void main(String[] args) {
		
	}

	/******************************************************************
	 * Initializes the variables for the game logic 
	 *****************************************************************/
	public GameLogic() {
		
		deck = new Deck();
		
		score = 0;
		difference = 0;
		
		tally = new int[14];
		
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
	 * @return the tally
	 *****************************************************************/
	public int[] getTally() {
		return tally;
	}

	
	

}
