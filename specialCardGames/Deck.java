package specialCardGames;

import java.util.Random;
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

	private int[][] deck;

	private ArrayList<Integer> shuffled;
	
	private Random randomSuitGen;
	
	private Random randomValueGen;
	
	private int randomSuit;
	
	private int randomValue;


	private final int SUITS = 4;

	private final int VALUES = 13;

	public static void main(String[] args) {
		Deck d = new Deck();
		d.printDeck();
		System.out.println(d.chooseSuit());
		System.out.println(d.blackOrRed(d.chooseSuit()));
		System.out.println(d.chooseValue());

	}


	/******************************************************************
	 * Creates a deck with suits and ranks of all 52 cards. Deck is 
	 * shuffled upon creation
	 *****************************************************************/
	public Deck() {

		deck = new int[VALUES][SUITS];
		shuffled = new ArrayList<Integer>();

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
		
		randomSuitGen = new Random();
		randomValueGen = new Random();
		
		randomSuit = randomSuitGen.nextInt(SUITS);
		randomValue = randomValueGen.nextInt(VALUES) + 2;
	} 


	/******************************************************************
	 * Shuffles the deck
	 *****************************************************************/
	public void shuffle() {

		Collections.shuffle(shuffled);

		for (int suit = 0; suit < SUITS; suit++) {	
			for (int value = 0; value < VALUES; value++) {
					deck[value][suit] = shuffled.get(value);
			}
			Collections.shuffle(shuffled);
		}
	}
	
	/******************************************************************
	 * Randomly chooses a value from the deck
	 * @return int value 2-14 that represents the value of each card.
	 * 11 is Jack, 12 is Queen, 13 is King, and 14 is Ace. 
	 *****************************************************************/
	public int chooseValue() {
		
		// Makes sure that there is a playable value in the suit
		int count = 0;
		for (int suit = 0; suit < SUITS; suit++) {
			if (deck[randomValue][suit] == 0) 
				count++;	
		}
		
		// If no playable cards, randomly pick new value and try again
		if (count == SUITS) {
			randomValue = randomValueGen.nextInt(VALUES);
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
	public int chooseSuit() {
		
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
	 * Checks whether the suit picked is black or red.
	 * @param suit - int from 0-3 that represents the suit chosen
	 * @return int value of 0 or 1. 0 if black, 1 if red.
	 *****************************************************************/
	public int blackOrRed(int suit) {
		if (chooseSuit() == 0 || chooseSuit() == 2)
			return 0;
		else
			return 1;
	}
	
	
	
	/******************************************************************
	 * Sets a card to be 0
	 * @param row - the row of the deck array 
	 * @param col - the column of the deck array
	 *****************************************************************/
	public void usedCard(int value, int suit) {
		deck[value][suit] = 0;	
	}
	
	/******************************************************************
	 * Checks if the card has been used or not. If it has been used
	 * then it will be 0 and then this method will return true
	 * @param row - the row of the deck array
	 * @param col - the column of the deck array
	 * @return true or false whether a card has been used
	 *****************************************************************/
	public boolean checkUsedCard(int value, int suit) {
		if (deck[value][suit] == 0)
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
