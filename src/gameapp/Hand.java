/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Class used to hold cards array.
 * @author bluebackdev
 */
public class Hand {
    /**
     * Created here instead of at the card level to save on memory. Pass
     * randomly generated integers to card objects instead.
     */
    private Random rand = new Random();
    
    /**
     * Create cards array with size based on game type with information
     * from Suit class.
     */
    private Card[] cards = new Card[Suit.getCardsInHand()];
    
    /**
     * The default constructor iterates through the cards array and inserts
     * card objects with randomly generated integers with a range based on the
     * number of cards in the game type's suit (4 or 76).
     */
    public Hand() {
//        do {
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                this.cards[i] = new Card(rand.nextInt(Suit.getCardsInSuit()));
            }
//        } while(!validateHandSabacc());
    }
    
    /**
     * Returns a string literal for displaying on the console based on the game
     * type and card's stored index value.
     * @param index Index value of the card in the cards array.
     * @return Returns a string for display in the console.
     */
    public String getCardStringAtIndex(int index) {
        return this.cards[index].getCardString();
    }
    
    /**
     * Returns an integer value for calculating hand score for Sabacc games
     * based on the card object's stored index value.
     * @param index Index value of the card in the cards array.
     * @return Returns an integer value for calculating hand score.
     */
    public int getCardValueAtIndex(int index) {
        return this.cards[index].getCardValue();
    }
    
    /**
     * Returns the length of the cards array for use in other classes.
     * @return Returns the length of the cards array.
     */
    public int getHandSize() {
        return this.cards.length;
    }
    
    /**
     * Loops through card array, uses cardIndex value stored in the card to
     * access a switch statement and pull the card object's face value and
     * add them to an accumulator.
     * @return Returns a total value for the cards array.
     */
    public int getHandValue() {
        int handValue = 0;
        
        for (Card card : this.cards) {
            handValue += card.getCardValue();
        }
        
        return handValue;
    }
    
    /**
     * Returns the entire cards array, necessary for sorting the cards array.
     * @return Returns the private cards array used by hand objects.
     */
    public Card[] getCardsArray() {
        return this.cards;
    }
     
    /**
     * Sorts a Sabacc hand by the cards face value.
     * @param cardArr Input hand to sort.
     * @return Returns a sorted cards array.
     */
    public Card[] sortHand(Card[] cardArr) {
        Arrays.sort(cardArr, new CompareBySuit() {
            @Override
            public Comparator<Card> reversed() {
                return super.reversed(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        return cardArr;
    }
    
    /**
     * This method is used for when cards randomly change and when a card
     * is selected for replacement.
     * @param index Index of the card array to modify.
     */
    public void replaceCardSuits(int index) {
        this.cards[index].incrementCardSuits();
    }
    
    /**
     * Replaces a card in the cards array based on an input index value.
     * @param index Index value of the card in the cards array to replace.
     */
    public void replaceCardSabacc(int index) {
        do {
            this.cards[index].setCardIndex(rand.nextInt(Suit.getCardsInSuit()));
        } while (!validateHandSabacc());
    }
    
    /**
     * Used by Sabacc to resize the players hand and add a card to the cards
     * array. Uses a temporary array with size +1 of cards.length, copies cards
     * to tempArr, then adds a random card to end of tempArr and validates
     * hand to make sure that the added card isn't a duplicate of an a card
     * that is already in the player's hand.
     */
    public void addCardToHand() {
        Card[] tempHand = new Card[this.cards.length + 1];
        
        for(int i = 0 ; i < cards.length ; i++) {
            tempHand[i] = cards[i];
        }
        
        cards = new Card[tempHand.length];
        
        for(int i = 0 ; i < cards.length ; i++) {
            cards[i] = tempHand[i];
        }
        
        do {
            cards[cards.length - 1] = new Card(rand.nextInt(Suit.getCardsInSuit()));
        } while (!validateHand());
    }

    /**
     * Used by Sabacc to resize the players hand and remove a card from the
     * cards array. Uses a temporary array of equal size to the cards array,
     * but excluding the card at the selected index value. This card is replaced
     * with a dummy value. Then the temporary hand is sorted, the dummy
     * value will always be at the end of the array. Recreate the cards array
     * -1 in size and copy the temporary array to the recreated cards array
     * without the final dummy value.
     * @param index Index value of the cards array to remove from the cards
     * array.
     */
    public void removeCardFromHand(int index) {
        Card[] tempHand = new Card[this.cards.length];
        
        for(int i = 0 ; i < tempHand.length ; i++) {
            if(index != i) {
                tempHand[i] = this.cards[i];
            }
            else if(index == i) {
                tempHand[i] = new Card(-1);
            }
        }
        
        sortHand(tempHand);
        
        cards = new Card[this.cards.length - 1];
        
        for(int i = 0 ; i < this.cards.length ; i++) {
            cards[i] = tempHand[i];
        }
    }

    /**
     * Used by the suits game to iterate through the cards array and randomly
     * decide whether cards should be incremented/changed. Uses a simple loop
     * and the random object to determine whether each individual card should
     * be changed or not.
     */
    public void randomizeHandSuits() {
        for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
            if (this.rand.nextInt(Suit.getRandomCardChangeProbability()) == 0) {
                this.cards[i].incrementCardSuits();
            }
        }
    }
    
    /**
     * This method is used by Sabacc to loop through the player's hand and
     * randomly decide if the card should be swapped for an entirely random
     * card from the Sabacc deck. Also does data validation to make sure that
     * duplicate cards are not drawn from the deck and placed in the player's
     * hand.
     */
    public void randomizeHandSabacc() {
        for (int i = 0 ; i < this.cards.length ; i++) {
//            for (int j = 0 ; j < i ; j++) {
//                do { 
//                    if (this.rand.nextInt(5) == 0) {
//                        this.cards[i].replaceCard(this.rand.nextInt(Suit.getCardsInSuit()));
//                    }
//                } while (!validateHandSabacc());
//            }
//            
            do { 
                if (this.rand.nextInt(Suit.getRandomCardChangeProbability()) == 0) {
                    this.cards[i].setCardIndex(this.rand.nextInt(Suit.getCardsInSuit()));
                }
            } while (!validateHandSabacc());
        }
    }
    
    /**
     * Returns whether or not the players hand is valid. Uses GameType to
     * determine which private validation method to call.
     * @return Returns true false whether hand is valid or not.
     */
    public boolean validateHand() {
        boolean isHandValid;
        
        switch(Suit.getGameType()) {
            case SUITS:
                isHandValid = validateHandSuits();
                break;
            case SABACC:
                isHandValid = validateHandSabacc();
                break;
            default:
                isHandValid = true;
                break;
        }
        
        return isHandValid;
    }
   
    /**
     * Determines whether game is over or not for Suits game. Iterates through
     * the cards array and compares each card's string value to the previous
     * card's string value. If at any point they are not equal, break the loop
     * and return false because there is a non-matching pair.
     * @return If game is over.
     */
    private boolean validateHandSuits() {
        for (int i = 1 ; i < Suit.getCardsInHand() ; i++) {
            if (!cards[i].getCardString().equals(cards[i-1].getCardString())) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Method used to validate whether the current Sabacc hand has duplicate
     * cards in it or not. Uses two loops to compare each card in the hand
     * to each other card in the hand. If they ever == one another, break the
     * loop and return false.
     * @return Returns whether the Sabacc hand has duplicate cards or not.
     */
    private boolean validateHandSabacc() {
        for (int i = 0 ; i < this.cards.length ; i++) {
            for (int j = 0 ; j < this.cards.length ; j++) {
                if (i != j) {
                    if (this.cards[i].getCardIndex() == this.cards[j].getCardIndex()) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}