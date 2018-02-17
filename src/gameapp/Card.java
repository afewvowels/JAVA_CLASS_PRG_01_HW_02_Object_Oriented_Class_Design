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
    
    public void setCardIndex(int input) {
        cardIndex = input;
    }
    
    public String getCardValue(int input) {
        return Suit.getCardValue(cardIndex);
    }
    
    public void incrementCardSuits() {
        if (cardIndex < Suit.getCardsInSuit()) {
            cardIndex++;
        }
        else {
            cardIndex = 0;
        }
    }
}
