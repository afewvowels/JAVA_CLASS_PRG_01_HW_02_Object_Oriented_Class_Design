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
 *
 * @author bluebackdev
 */
public class Hand {
    private int handValue;
    
    Random rand = new Random();
    
    Card[] cards = new Card[Suit.getCardsInHand()];
    
    public Hand() {
        do {
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                this.cards[i] = new Card(rand.nextInt(Suit.getCardsInSuit()));
            }
        } while(!validateHandSabacc());
    }
    
    public String getCardStringAtIndex(int index) {
        return this.cards[index].getCardString();
    }
    
    public int getCardValueAtIndex(int index) {
        return this.cards[index].getCardValue();
    }
    
    public int getHandSize() {
        return this.cards.length;
    }
    
    public int getHandValue() {
        handValue = 0;
        
        for (Card card : this.cards) {
            this.handValue += card.getCardValue();
        }
        
        return handValue;
    }
    
    public void replaceCard(int index) {
        this.cards[index].incrementCardSuits();
    }
    
    public void replaceCardSabacc(int index) {
        do {
            this.cards[index].replaceCard(rand.nextInt(Suit.getCardsInSuit()));
        } while (!validateHandSabacc());
    }
    
    public void sortHand() {
        Arrays.sort(this.cards, new CompareBySuit() {
            @Override
            public Comparator<Card> reversed() {
                return super.reversed(); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void randomizeHandSuits() {
        for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
            if (this.rand.nextInt(5) == 0) {
                this.cards[i].incrementCardSuits();
            }
        }
    }
    
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
                if (this.rand.nextInt(5) == 0) {
                    this.cards[i].replaceCard(this.rand.nextInt(Suit.getCardsInSuit()));
                }
            } while (!validateHandSabacc());
        }
    }
    
    public boolean validateHand() {
        boolean isGameOver;
        
        switch(Suit.getGameType()) {
            case SUITS:
                isGameOver = validateHandSuits();
                break;
            case SABACC:
//                isGameOver = validateHandSabacc();
                isGameOver = false;
                break;
            default:
                isGameOver = true;
                break;
        }
        
        return isGameOver;
    }
   
    private boolean validateHandSuits() {
        for (int i = 1 ; i < Suit.getCardsInHand() ; i++) {
            if (!cards[i].getCardString().equals(cards[i-1].getCardString())) {
                return false;
            }
        }
        
        return true;
    }
    
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