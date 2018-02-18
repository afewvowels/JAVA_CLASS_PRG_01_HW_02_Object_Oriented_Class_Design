/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

/**
 * This class contains card logic and stores the cards values. Calls to Suit
 * class fill in card details.
 * @author bluebackdev
 */
public class Card {
//    private String cardValue;
    // Card index value, initialized at -1
    private int cardIndex = -1;
    
    /**
     * Constructor takes in an index value, randomly generated in Hand class,
     * and assigns it to the Card object. Index is used to determine card
     * string representation and card value in conjunction with Suit class.
     * @param input Value to create card with.
     */
    public Card(int input) {
        this.cardIndex = input;
    }
    
    /**
     * Used to adjust Card object's index value.
     * @param input Value to change Card object's index value.
     */
    public void setCardIndex(int input) {
        this.cardIndex = input;
    }
    
    /**
     * Use card index value to call Suit class to return Card's string
     * representation.
     * @return A string representation of the card value based on Card's index
     */
    public String getCardString() {
        return Suit.getCardString(cardIndex);
    }
    
    /**
     * Use card index value to call Suit class to return Card's face value.
     * @return An integer value of the card's face value based on the Card's
     * index value.
     */
    public int getCardValue() {
        return Suit.getCardValue(cardIndex);
    }
    
    /**
     * Returns the cards index value, used for comparisons.
     * @return The Card object's cardIndex value.
     */
    public int getCardIndex() {
        return this.cardIndex;
    }
    
    /**
     * Increments the card's index value, used for Suits game card changes.
     */
    public void incrementCardSuits() {
        cardIndex++;
        
        if(cardIndex == Suit.getCardsInSuit()) {
            cardIndex = 0;
        }
    }
}
