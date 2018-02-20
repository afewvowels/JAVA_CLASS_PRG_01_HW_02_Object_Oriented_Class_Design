/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.util.Scanner;
import java.lang.Math;
import static java.lang.Math.abs;
/**
 * This application allows the user to play two card games, Suits and Sabacc
 * @author bluebackdev
 */
public class GameApp {
    
    // Used for selecting active game.
    public static int selection = -1;

    // Used for getting user inputs
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
//      String used to store user inputs
        String input;
        
//      Display menu options to player for game types.  
        System.out.println("Please choose your gametype:");
        System.out.println("\t1. Suits");
        System.out.println("\t2. Sabacc");
        System.out.print("Choice: ");
        
//      Get user input for menu selection, loop while it's invalid
        do {
            input = keyboard.nextLine();
        } while (!input.toUpperCase().equals("SUITS") &&
                !input.toUpperCase().equals("SABACC") &&
                !input.equals("1") && !input.equals("2"));
        
//      Switch statement would be a better choice here if there were more game
//      types, used a simple if / else if statement because there are only two
//      game types at the moment.
//      Set the game type in Suit class and then call the appropriate method
//      from GameApp to run the game.
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
//      Create a hand object
        Hand hand = new Hand();
        
//      Used to keep track of the number of turns that the user takes to get
//      a matching set of cards for display at end of round.
        int turnsTaken = 0;
        
//      Main game logic loop, runs while the hand is invalid (not three matching
//      suit cards)
        do {
//          On game creation, before displaying the hand to the player,
//          validate that the hand is not a winning hand (i.e. three matching
//          suit cards). If it is a winning hand, redraw the hand until it
//          isn't a winning hand.
            while (hand.validateHand()) {
                hand = new Hand();
            }
            
//          Loop through the cards in the hand object and output them to the
//          console for the player to view.
            System.out.println("This is your hand:");
            for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
                System.out.print(hand.getCardStringAtIndex(i) + "\t");
            }
            
//          Display card selection dialogue to the player and validate user
//          input (loop while invalid).
            do {
                System.out.print("\nSelect a card to discard (1-3): ");
                selection = keyboard.nextInt();
            } while (selection < 1 || selection > 3);
            
//          Replace the user-selected card.
            hand.replaceCardSuits(selection - 1);
//          Randomize the hand.
            hand.randomizeHandSuits();
            
//          Increment turns taken counter
            turnsTaken++;
        } while (!hand.validateHand());
        
//      Only winning message here, game continues until a winning hand has been
//      drawn. Also outputs number of tries/turns it took the user to get a
//      matching set of cards.
        System.out.println("\nWinning hand:");
        for (int i = 0 ; i < Suit.getCardsInHand() ; i++) {
            System.out.print(hand.getCardStringAtIndex(i) + "\t");
        }
        System.out.println("\nYou took " + turnsTaken + "turns to win!");
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
        // Counter to determine number of rounds, initialize at 1
        int round = 1;
        
        // Constant used for number of rounds, easy to change here
        final int NUM_ROUNDS = 6;
        
        // Create hand object for player.
        Hand playerHand = new Hand();
//        FUTURE USE: Want to create dealer/house hand for
//        player to play against
        Hand dealerHand = new Hand();

        // Main game logic loop, runs while rounds < NUM_ROUNDS
        do {            
            // Validate that there are no duplicate cards in the players hand.
            // If there are duplicates, redraw the hand until the hand is valid
            while (!playerHand.validateHand()) {
                playerHand = new Hand();
            }
            
//            while (!dealerHand.validateHand()) {
//                dealerHand = new Hand();
//            }
//            DEBUG: Original unsorted hand available for display
//            System.out.println("This is your hand:");
//            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
//                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
//            }

////          Print out the sorted hand for the player to view
//            System.out.println("\nThis is the dealer's hand:");
//            playerHand.sortHand(dealerHand.getCardsArray());
//            for (int i = 0 ; i < dealerHand.getHandSize() ; i++) {
//                System.out.print(dealerHand.getCardStringAtIndex(i) + "\t");
//            }
//            
////          Print out the hands total score for the player to view
//            System.out.print("\nThis is the value of the dealer's hand:\n");
//            for (int i = 0 ; i < dealerHand.getHandSize() ; i++) {
//                System.out.print(dealerHand.getCardValueAtIndex(i));
//                if (i != dealerHand.getHandSize() - 1) {
//                    System.out.print(" + ");
//                }
//            }
//            System.out.print(" = " + dealerHand.getHandValue());
            
//          Print out the sorted hand for the player to view
            System.out.println("\nThis is your sorted hand:");
            playerHand.sortHand(playerHand.getCardsArray());
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardStringAtIndex(i) + "\t");
            }
            
//          Print out the hands total score for the player to view
            System.out.print("\nThis is the value of your hand:\n");
            for (int i = 0 ; i < playerHand.getHandSize() ; i++) {
                System.out.print(playerHand.getCardValueAtIndex(i));
                if (i != playerHand.getHandSize() - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.print(" = " + playerHand.getHandValue());
            
//          Action menu, select appropriate action for the turn:
//              1. Draw a card
//              2. Swap a card
//              3. Discard a card
//              4. Take no action
            System.out.println("\nSelect an action:");
            System.out.println("\t1.Draw a Card");
            System.out.println("\t2.Swap a Card");
            System.out.println("\t3.Discard a Card");
            System.out.println("\t4.Take no Action");
            System.out.print("Selection: ");
            selection = keyboard.nextInt();
            
//          Switch logic that takes user menu-selection input and parses it
//          to determine what action to take.
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
            
//            if(dealerHand.getHandValue() < -23 || dealerHand.getHandValue() > 23) {
//                dealerHand.removeCardFromHand(dealerHand.getHandSize() - 1);
//            }
//            else if((dealerHand.getHandValue() < 23 && dealerHand.getHandValue() > 15) ||
//                    (dealerHand.getHandValue() > -23 && dealerHand.getHandValue() < -15)) {
//                
//            }
//            else if(dealerHand.getHandValue() <= -15 || dealerHand.getHandValue() <= 15) {
//                dealerHand.addCardToHand();
//            }

//          Randomization of hand occurs here once all actions have been taken
            System.out.println("\nHand is randomizing");
            playerHand.randomizeHandSabacc();

//          Increment the round counter and loop back to the beginning of the
//          turn logic
            round++;
        } while (round < NUM_ROUNDS);

//      Calculate the hands final value after all rounds have been completed
//      and determine if the player has stayed between -23 and 23 or if they've
//      bombed out and display the relevant information and the player's
//      final hand to them along with their hand's score.
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
//        if(abs(playerHand.getHandValue()) > abs(dealerHand.getHandValue()) &&
//                abs(playerHand.getHandValue()) <= 23) {
//            System.out.println("\nYou won!");
//        }
//        else if(abs(playerHand.getHandValue()) <= abs(dealerHand.getHandValue())
//                && abs(dealerHand.getHandValue()) <= 23) {
//            System.out.println("\nThe house wins!");
//        }
        else {
            System.out.println("\nYou bombed out!");
        }
        
        System.out.println("\nGAME OVER");
    }
}