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
    private Random rand = new Random();
    
    private Card[] cards = new Card[Suit.getCardsInHand()];
    
    public Hand() {
//        do {
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                this.cards[i] = new Card(rand.nextInt(Suit.getCardsInSuit()));
            }
//        } while(!validateHandSabacc());
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
        int handValue = 0;
        
        for (Card card : this.cards) {
            handValue += card.getCardValue();
        }
        
        return handValue;
    }
    
    public Card[] getCardsArray() {
        return this.cards;
    }
        
    public Card[] sortHand(Card[] cardArr) {
        Arrays.sort(cardArr, new CompareBySuit() {
            @Override
            public Comparator<Card> reversed() {
                return super.reversed(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        return cardArr;
    }
    
    public void replaceCardSuits(int index) {
        this.cards[index].incrementCardSuits();
    }
    
    public void replaceCardSabacc(int index) {
        do {
            this.cards[index].replaceCard(rand.nextInt(Suit.getCardsInSuit()));
        } while (!validateHandSabacc());
    }
    
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
                isGameOver = validateHandSabacc();
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