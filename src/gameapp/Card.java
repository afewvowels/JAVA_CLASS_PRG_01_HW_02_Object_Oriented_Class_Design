/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

/**
 *
 * @author bluebackdev
 */
public class Card {
//    private String cardValue;
    private int cardIndex = -1;
    
    public Card(int input) {
        cardIndex = input;
    }
    
    public void setCardIndex(int input) {
        cardIndex = input;
    }
    
    public String getCardString() {
        return Suit.getCardString(cardIndex);
    }
    
    public int getCardValue() {
        return Suit.getCardValue(cardIndex);
    }
    
    public int getCardIndex() {
        return this.cardIndex;
    }
    
    public void incrementCardSuits() {
        cardIndex++;
        
        if(cardIndex == Suit.getCardsInSuit()) {
            cardIndex = 0;
        }
    }
    
    public void replaceCard(int index) {
        this.cardIndex = index;
    }
}
