package specialCardGames;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.*;

/**********************************************************************
 *  @author Jarod Collier, Maz Ashgar, Josh Lowell
 *  @version 9/28/2018
 *
 *  Deal 52 cards uniformly at random. Cards include:
 *  
 *  Ace of Clubs
 *  8 of Diamonds
 *  5 of Diamonds
 *  ...
 *  8 of Hearts
 *  
 *  Order of suits is Black-Red-Black-Red. Hence the order is:
 *  Spades, Hearts, Clubs, and Diamonds
 *
 *********************************************************************/

public class Deck {

	/** 2D array used to hold all card values */
	private int[][] deck;

	/** List of possible card values to be shuffled */
	private ArrayList<Integer> shuffled;

	/** ArraylIST of cards that have been chosen */
	private ArrayList<Integer> chosenCards;

	/** Random number generator for the suit */
	private Random randomSuitGen;

	/** Random number generator for the value */
	private Random randomValueGen;

	/** int used to keep track of the suit being picked */
	private int randomSuit;

	/** int used to keep track of the value being picked */
	private int randomValue;

	/** final variable used for the number of suits in a deck */
	private final int SUITS = 4;

	/** final variable used for the number of values in a deck */
	private final int VALUES = 13;

	public static void main(String[] args) {
		Deck d = new Deck();
		d.printDeck();

		for (int i = 0; i < 52; i++) {
			System.out.println("\nThe chosen card has a value of: " + d.chooseCard() + "\n");
			d.printDeck();
		};

		System.out.println(d.getLastChosenCard());
		
		System.out.println(d.blackOrRed());
		System.out.println(d.lowerOrHigher());
		System.out.println(d.insideOrOutside());
		System.out.println(d.guessSuit(2));
		System.out.println(d.guessCard(7));
		System.out.println(d.checkFaceCard());
	}


	/******************************************************************
	 * Creates a deck with suits and ranks of all 52 cards. Deck is 
	 * shuffled upon creation
	 *****************************************************************/
	public Deck() {

		// Instantiates lists and arrays
		deck = new int[VALUES][SUITS];
		shuffled = new ArrayList<Integer>();
		chosenCards = new ArrayList<Integer>();

		// Add values into the deck
		for (int value = 0; value < VALUES; value++) {
			for (int suit = 0; suit < SUITS; suit++) {	
				deck[value][suit] = value + 2;		
			}
		}

		// Add possible values to be shuffled
		for (int shuffle = 0; shuffle < VALUES; shuffle++)
			shuffled.add(shuffle + 2);


		shuffle(); 

		// Instantiates random number generators
		randomSuitGen = new Random();
		randomValueGen = new Random();

		// Instantiates random suit and value variables
		randomSuit = randomSuitGen.nextInt(SUITS);
		randomValue = randomValueGen.nextInt(VALUES) + 2;
	} 

	/******************************************************************
	 * Gets the suit value that is chosen at random
	 * @return the randomSuit value
	 *****************************************************************/
	public int getRandomSuit() {
		return randomSuit;
	}


	/******************************************************************
	 * Sets the suit to be something the user chooses
	 * @param randomSuit - the randomSuit to set
	 *****************************************************************/
	public void setRandomSuit(int randomSuit) {
		this.randomSuit = randomSuit;
	}


	/******************************************************************
	 * Gets the value of the card that is chosen at random
	 * @return the randomValue of the card
	 *****************************************************************/
	public int getRandomValue() {
		return randomValue;
	}


	/******************************************************************
	 * Sets the value of a card to whatever the user chooses
	 * @param randomValue - the randomValue to set
	 *****************************************************************/
	public void setRandomValue(int randomValue) {
		this.randomValue = randomValue;
	}

	
	/******************************************************************
	 * Gets the last card that was chosen from the deck
	 * @return int value of the most recently chosen card
	 *****************************************************************/
	public int getLastChosenCard() {
		return chosenCards.get(chosenCards.size() -1);
	}


	/******************************************************************
	 * Shuffles the deck
	 *****************************************************************/
	public void shuffle() {

		// Shuffles the ArrayList of possible values
		Collections.shuffle(shuffled);

		// Takes the shuffled arrayList and adds the values to the deck
		for (int suit = 0; suit < SUITS; suit++) {	
			for (int value = 0; value < VALUES; value++) {
				deck[value][suit] = shuffled.get(value);
			}

			// Shuffles the arrayList so each suit is shuffled
			Collections.shuffle(shuffled);
		}
	}

	/******************************************************************
	 * Randomly chooses a value from the deck
	 * @return int value 2-14 that represents the value of each card.
	 * 11 is Jack, 12 is Queen, 13 is King, and 14 is Ace. 
	 *****************************************************************/
	private int chooseValue() {

		// Resets the random value
		randomValue = randomValueGen.nextInt(VALUES) + 2;

		// Makes sure that there is a playable value in the suit
		int count = 0;
		for (int suit = 0; suit < SUITS; suit++) {
			if (deck[randomValue - 2][suit] == 0) 
				count++;	
		}

		// If no playable cards, randomly pick new value and try again
		if (count == SUITS) {
			randomValue = randomValueGen.nextInt(VALUES) + 2;
			return chooseValue();
		}
		else {
			return randomValue;
		}

	}


	/******************************************************************
	 * Randomly chooses a suit from the deck
	 * @return int value 0-3 that represents the suit. 0 is Spades, 1
	 * is Hearts, 2 is Clubs, and 3 is Diamonds
	 *****************************************************************/
	private int chooseSuit() {

		// Resets the random suit value
		randomSuit = randomSuitGen.nextInt(SUITS);

		// Makes sure that there is a playable card in the suit
		int count = 0;
		for (int val = 0; val < VALUES; val++) {
			if (deck[val][randomSuit] == 0) 
				count++;	
		}

		// If no playable cards, randomly pick new suit and try again
		if (count == VALUES) {
			randomSuit = randomSuitGen.nextInt(SUITS);
			return chooseSuit();
		}
		else {
			return randomSuit;
		}

	}

	/******************************************************************
	 * Takes a random value and random suit and actually chooses to 
	 * place or use that card. Once the card is used it is removed.
	 * @return 2D int array representing the chosen cards
	 * @throws IllegalArgumentException when the deck is empty but a 
	 * card is attempted to be chosen
	 *****************************************************************/
	public int chooseCard(){

		// Checks if the deck is empty
		if (emptyDeck())
			throw new IllegalArgumentException("Deck is empty");

		// Get a random value for the suit and value
		chooseSuit();
		chooseValue();

		if (checkUsedCard(randomValue - 2, randomSuit))
			return chooseCard();

		// Adds the choice to a list of chosen cards
		chosenCards.add(deck[randomValue - 2][randomSuit]);

		// Removes the chosen card from the deck
		usedCard(randomValue - 2, randomSuit);

		return chosenCards.get(chosenCards.size() -1); 

	}

	/******************************************************************
	 * Checks whether the suit picked is black or red.
	 * @return int value of 0 or 1. 0 if black, 1 if red.
	 *****************************************************************/
	public int blackOrRed() {

		// If the card is a spade or club, it's black, so return 0
		if (randomSuit == 0 || randomSuit == 2)
			return 0;
		else
			return 1;
	}

	/******************************************************************
	 * Checks whether new card is higher, lower, or equal to the 
	 * previous card
	 * @return -1, 0, or 1 depending on if lower, equal, or higher
	 * @throws IllegalArgumentException when not enough cards have been
	 * picked
	 *****************************************************************/
	public int lowerOrHigher() {

		// Checks if at least 2 cards have been chosen to compare
		if (chosenCards.size() > 1) {

			// If recent card is bigger, return 1
			if (chosenCards.get(chosenCards.size() - 1) >
			(chosenCards.get(chosenCards.size() - 2)))
				return 1;

			// If recent card is smaller, return -1
			else if (chosenCards.get(chosenCards.size() - 1) <
					(chosenCards.get(chosenCards.size() - 2)))
				return -1;

			// If cards are the same, return 0
			else
				return 0;	
		}
		else
			throw new IllegalArgumentException("Can't compare cards");

	}

	/******************************************************************
	 * Determines whether the next card is inside, outside, or equal
	 * to the previous 2 cards
	 * @return -1, 0, or 1 whether the card is inside, equal,
	 * or outside
	 * @throws IllegalArgumentException when you can't compare cards
	 *****************************************************************/
	public int insideOrOutside() {

		int first = chosenCards.get(chosenCards.size() - 3);
		int second = chosenCards.get(chosenCards.size() - 2);
		int third = chosenCards.get(chosenCards.size() - 1);

		// Checks if at least 3 cards have been chosen to compare
		if (chosenCards.size() > 2) {

			// checks if recent card's value is inside others
			if (third > first && third < second)
				return -1;

			// checks if recent card's value is outside others
			else if ( (third > first && third > second) ||
					(third < first && third < second))
				return 1;

			// if those don't work, recent card equals one of the cards
			else
				return 0;
		}
		else
			throw new IllegalArgumentException("Can't compare cards");

	}

	/******************************************************************
	 * Checks if the user's guess is the same as the card
	 * @param guessSuit - the value of the suit the user guesses
	 * @return true or false whether the user is right or wrong
	 * @throws IllegalArgumentException when you can't compare cards
	 *****************************************************************/
	public boolean guessSuit(int guessSuit) {

		// Makes sure there is a card to guess the suit from
		if (chosenCards.size() >= 1) {

			// Checks if chosen card's suit is the same as guessSuit
			if (getRandomSuit() == guessSuit)
				return true;
			else 
				return false;		
		}
		else
			throw new IllegalArgumentException("Must pick a card");

	}


	/******************************************************************
	 * Checks if the user's guessed card is the same as what the 
	 * System chose
	 * @param guessValue - the value that the user chooses
	 * @return true or false whether the user was right or wrong
	 * @throws IllegalArgumentException when you can't compare cards
	 *****************************************************************/
	public boolean guessCard(int guessValue) {

		// Makes sure there is a card to guess the value from
		if (chosenCards.size() >= 1) {

			// Checks if chosen card's suit is the same as guessSuit
			if (getRandomValue() == guessValue)
				return true;
			else
				return false;
		}
		else
			throw new IllegalArgumentException("Must pick a card");

	}

	/******************************************************************
	 * Checks if the current card chosen is a face card
	 * @return true or false if card is a face card
	 * @throws IllegalArgumentException when you can't compare cards
	 *****************************************************************/
	public boolean checkFaceCard () {

		// Makes sure there is a card to guess from
		if (chosenCards.size() >= 1) {

			// Checks if card has value of a face card
			if (getLastChosenCard() == 11 || getLastChosenCard() == 12 
					|| getLastChosenCard() == 13 
					|| getLastChosenCard() == 14)
				return true;
			else
				return false;			
		}
		else
			throw new IllegalArgumentException("Must pick a card");
	}

	/******************************************************************
	 * Sets a card to be 0
	 * @param value - the row of the deck array
	 * @param suit - the column of the deck array
	 *****************************************************************/
	public void usedCard(int value, int suit) {
		deck[value][suit] = 0;	
	}

	/******************************************************************
	 * Checks if the card has been used or not. If it has been used
	 * then it will be 0 and then this method will return true
	 * @param value - the row of the deck array
	 * @param suit - the column of the deck array
	 * @return true or false whether a card has been used
	 *****************************************************************/
	public boolean checkUsedCard(int value, int suit) {
		if (deck[value][suit] == 0)
			return true;
		else
			return false;
	}

	/******************************************************************
	 * Checks whether the deck is empty
	 * @return true or false whether the deck is empty
	 *****************************************************************/
	public boolean emptyDeck() {

		// Checks whether the deck has cards in it
		int count = 0;
		for (int value = 0; value < VALUES; value++) {
			for (int suit = 0; suit < SUITS; suit++) {	
				if (checkUsedCard(value, suit))
					count++;		
			}
		}

		// If there are no available cards, return return
		if (count == SUITS * VALUES)
			return true;
		else
			return false;

	}


	/******************************************************************
	 * Prints the deck
	 *****************************************************************/
	public void printDeck() {

		// Used to make the console look like a table
		int n = 0;

		// print shuffled deck
		for (int suit = 0; suit < SUITS; suit++) {	
			for (int value = 0; value < VALUES; value++) {
				System.out.print("" + deck[value][suit] + " ");
				n++;

				if (n % 13 == 0)
					System.out.println("");
				
				
			}
		}
	}

}
