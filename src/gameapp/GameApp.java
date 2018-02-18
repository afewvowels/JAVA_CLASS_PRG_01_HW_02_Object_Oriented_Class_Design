/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.util.Scanner;
/**
 * This application allows the user to play two card games, Suits and Sabacc
 * @author bluebackdev
 */
public class GameApp {
    public static int selection = -1;

    static Scanner keyboard = new Scanner(System.in);
    
    /**
     * Main method, calls showMenu() method.
     * @param args 
     */
    public static void main(String[] args) {
        showMenu();
    }
    
    /**
     * Main menu method that displays game selection menu and prompts user for
     * selection, validates selection, sets game mode, and calls appropriate
     * game method.
     * @param input Temp variable used to keep track of user input
     */
    private static void showMenu() {
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
    
    /**
     * This method implements the game logic for the Suits game type,
     * including the menu dialogue options and data validation.
     * @param hand Hand object that the method uses for the game
     */
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
            
            do {
                System.out.print("\nSelect a card to discard (1-3): ");
                selection = keyboard.nextInt();
            } while (selection < 1 || selection > 3);
            
            hand.replaceCardSuits(selection - 1);
            hand.randomizeHandSuits();
            
        } while (!hand.validateHand());
        
        System.out.println("\nWinning hand:");
        for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
            System.out.print(hand.getCardStringAtIndex(i) + "\t");
        }
        System.out.println("\nGAME OVER");
    }
    
    /**
     * This method implements the game logic for the Sabacc game type,
     * including the menu dialogue options and data validation.
     * @param round Counter that keeps track of the number of turns that the
     * user has been through
     * @param playerHand Hand object that the method uses for the game
     */
    private static void sabaccGame() {
        int round = 1;
        
        Hand playerHand = new Hand();
//        Hand dealerHand = new Hand();

        do {            
            while (!playerHand.validateHand()) {
                playerHand = new Hand();
            }
//            System.out.println("This is your hand:");
//            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
//                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
//            }
            
            System.out.println("\nThis is your sorted hand:");
            playerHand.sortHand(playerHand.getCardsArray());
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
            
            System.out.print("\nThis is the value of your hand:\n");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardValueAtIndex(i));
                if (i != playerHand.getHandSize() - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.print(" = " + playerHand.getHandValue());
            
            System.out.println("\nSelect an action:");
            System.out.println("\t1.Draw a Card");
            System.out.println("\t2.Swap a Card");
            System.out.println("\t3.Discard a Card");
            System.out.println("\t4.Take no Action");
            System.out.print("Selection: ");
            selection = keyboard.nextInt();
            
            switch(selection) {
                case 1:
                    playerHand.addCardToHand();
                    break;
                case 2:
                    System.out.print("\nSelect a card to swap (1-"
                            + playerHand.getHandSize() + "): ");
                    selection = keyboard.nextInt();
                    playerHand.replaceCardSabacc(selection - 1);
                    break;
                case 3:
                    System.out.print("\nSelect a card to Discard (1-"
                            + playerHand.getHandSize() + "): ");
                    selection = keyboard.nextInt();
                    playerHand.removeCardFromHand(selection - 1);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

            System.out.println("\nHand is randomizing");
            playerHand.randomizeHandSabacc();

            round++;
        } while (round < 6);

        if (playerHand.getHandValue() >= -23 && playerHand.getHandValue() <= 23) {
            System.out.println("\nWinning hand:");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
            System.out.print("\nThis is the value of your hand:\n");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardValueAtIndex(i));
                if (i != playerHand.getHandSize() - 1) {
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