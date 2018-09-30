package specialCardGames;

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
 *********************************************************************/

public class Deck {
	
	private String[] deck;
	
	private int size, index;
	
	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d.topCardValue());
	
		d.nextCard();
		System.out.println(d.topCardValue());
		d.nextCard();
		System.out.println(d.topCardValue());

	}
	
	
	/******************************************************************
	 * Creates a deck with suits and ranks of all 52 cards. Deck is 
	 * shuffled upon creation
	 *****************************************************************/
	public Deck() {
		
		 String[] SUITS = {
		            "Clubs", "Diamonds", "Hearts", "Spades"
		        };

		        String[] RANKS = {
		            "2", "3", "4", "5", "6", "7", "8", "9", "10",
		            "Jack", "Queen", "King", "Ace"
		        };
		        
		        // initialize deck
		        size = SUITS.length * RANKS.length;
		        deck = new String[size];
		        for (int i = 0; i < RANKS.length; i++) {
		            for (int j = 0; j < SUITS.length; j++) {
		                deck[SUITS.length*i + j] = RANKS[i] + " of "
		            + SUITS[j];
		                }
		        }   
		        index = 0;
		        shuffle();   
	} 
	

	/******************************************************************
	 * @return the index
	 *****************************************************************/
	public int getIndex() {
		return index;
	}


	/******************************************************************
	 * @param index the index to set
	 *****************************************************************/
	public void setIndex(int index) {
		this.index = index;
	}


	/******************************************************************
	 * Shuffles the deck
	 *****************************************************************/
    public void shuffle() {
    	
    	// shuffle
        for (int i = 0; i < size; i++) {
            int r = i + (int) (Math.random() * (size-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
    }
    
    /******************************************************************
     * Looks at the first card of the deck
     *****************************************************************/
    public String showTopCard() {	
    	return deck[index];	
    }
    
    /******************************************************************
     * Looks at the top card of the deck and finds its integer
     * equivalent number.
     * @return int value of the card on the top of the deck
     *****************************************************************/
    public int topCardValue() {
    	
    	int cardValue;
    	
    	String[] temp = showTopCard().split(" ");
    	
    	// Checks for face cards
    	if(temp[0].equals("King")) 
    		cardValue = 13;
    	else if(temp[0].equals("Queen")) 
    		cardValue = 12;
    	else if(temp[0].equals("Jack")) 
    		cardValue = 11;
    	else if(temp[0].equals("Ace")) 
    		cardValue = 1;
    	
    	// Checks value of number cards
    	else 
    		cardValue = Integer.parseInt(temp[0]);
    	 	
    	return cardValue;	
    }
    
    /******************************************************************
     * Discards the top card
     *****************************************************************/
    public void nextCard() {
    	index++;
    }
    
    /******************************************************************
     * Prints the deck
     *****************************************************************/
    public void printDeck() {
    	
    	// print shuffled deck
        for (int i = 0; i < size; i++) 
            System.out.println(deck[i]);
    }

}
