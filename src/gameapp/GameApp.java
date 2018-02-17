/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.util.Scanner;
/**
 *
 * @author bluebackdev
 */
public class GameApp {

    /**
     * @param args the command line arguments
     */
    public static int selection = -1;

    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        String input;
        
        System.out.println("Please choose your gametype:");
        System.out.println("\t1. Suits");
        System.out.println("\t2. Sabacc");
        System.out.print("Choice: ");
        
        do {
            input = keyboard.nextLine();
        } while (!input.toUpperCase().equals("SUITS") &&
                !input.toUpperCase().equals("SABACC") &&
                !input.equals("1") && !input.equals("2"));
        
        if (input.toUpperCase().equals("1") ||
                input.toUpperCase().equals("SUITS")) {
            Suit.setGameType(Suit.GameType.SUITS);
            suitsGame();
        }
        else if (input.toUpperCase().equals("2") ||
                input.toUpperCase().equals("SABACC")) {
            Suit.setGameType(Suit.GameType.SABACC);
            sabaccGame();
        }
    }
    
    private static void suitsGame() {
        Hand hand = new Hand();
        
        do {
            while (hand.validateHand()) {
                hand = new Hand();
            }
            
            System.out.println("This is your hand:");
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                System.out.print(hand.getCardStringAtIndex(i) + "\t");
            }
            System.out.print("\nSelect a card to discard (1-3): ");
            selection = keyboard.nextInt();
            
            hand.replaceCard(selection - 1);
            hand.randomizeHandSuits();
            
        } while (!hand.validateHand());
        
        System.out.println("\nWinning hand:");
        for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
            System.out.print(hand.getCardStringAtIndex(i) + "\t");
        }
        System.out.println("\nGAME OVER");
    }
    
    private static void sabaccGame() {
        int handValue;
        int round = 1;
        
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        do {
            handValue = 0;
            
            System.out.println("This is your hand:");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
            
            System.out.println("\nThis is your sorted hand:");
            playerHand.sortHand();
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
            
            System.out.print("\nThis is the value of your hand: ");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardValueAtIndex(i));
                if (i != Suit.getCardsInHand() - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.print(" = " + playerHand.getHandValue());
            
            System.out.print("\nSelect a card to discard (1-"
                    + playerHand.getHandSize() + "): ");
            selection = keyboard.nextInt();

            playerHand.replaceCardSabacc(selection - 1);
            playerHand.randomizeHandSabacc();

            round++;
        } while (round < 6);

        if (playerHand.getHandValue() >= -23 && playerHand.getHandValue() <= 23) {
            System.out.println("\nWinning hand:");
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
                        
            System.out.print("\nThis is the value of your hand: ");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardValueAtIndex(i));
                if (i != Suit.getCardsInHand() - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.print(" = " + playerHand.getHandValue());
        }
        else {
            System.out.println("\nYou bombed out!");
        }
        
        System.out.println("\nGAME OVER");
    }
}