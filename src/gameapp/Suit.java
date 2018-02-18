/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;
/**
 * Static class that is used to store game type information and returns
 * strings and integer values to other game objects.
 * @author bluebackdev
 */
public class Suit {
    // Used to regulate numerous switch statements based on selected gametype
    public enum GameType {
        SUITS, SABACC
    }
    
    // Defines gametype, set at game beginning
    private static GameType gameType;
    
    // Defines # of cards in suit and # of cards in starting hand.
    // Useful for randomly selecting a new card: 
    //    rand.nextInt(Suit.cardsInSuit);
    // Useful for creating new hand objects:
    //    Card[] cards = new Cards[Suit.cardsInHand];
    private static int cardsInSuit;
    private static int cardsInHand;
    
    // Useful for changing symbols associated with Sabacc suits.
    // Better than hardcoding in switch statements.
    private static String suitCoins = "\u2446";
    private static String suitFlasks = "\u2447";
    private static String suitSabres = "\u2448";
    private static String suitStaves = "\u2449";
    private static String suitFaceCards = "\u244a";
    
    /**
     * Used to set game type variable and initialize variables cardsInSuit
     * and cardsInHand.
     * @param gt Input game type.
     */
    public static void setGameType(GameType gt) {
        gameType = gt;
        
        switch(gameType) {
            case SUITS:
                cardsInSuit = 4;
                cardsInHand = 3;
                break;
            case SABACC:
                cardsInSuit = 76;
                cardsInHand = 2;
                break;
            default:
                cardsInSuit = -1;
                cardsInHand = -1;
                break;
        }
    }
    
    /**
     * Returns number of cards in suit based on game type.
     * @return Number of cards in the game types suit.
     */
    public static int getCardsInSuit() {
        return cardsInSuit;
    }
    
    /**
     * Returns the number of starting cards in a hand based on game type.
     * @return Number of cards in a new hand based on game type.
     */
    public static int getCardsInHand() {
        return cardsInHand;
    }
    
    /**
     * Returns game type.
     * @return Game type.
     */
    public static GameType getGameType() {
        return gameType;
    }
    
    /**
     * Public method that returns a string literal based on an input integer,
     * usually the cardIndex of a card object. Uses private methods that
     * contain game-specific switch statements that return values based
     * on that input integer.
     * @param input Index to lookup with private, game-specific switch statement
     * @return A string representation of the cardIndex value.
     */
    public static String getCardString(int input) {
        String value;
        
        switch(gameType) {
            case SUITS:
                value = getSuitsString(input);
                break;
            case SABACC:
                value = getSabaccString(input);
                break;
            default:
                value = "NULL";
                break;
        }
        
        return value;
    }
    
    /**
     * Public method that returns a cards value based on its cardIndex value.
     * Currently only a single game type calls this method (Sabacc) but could
     * be expanded to include other game methods easily.
     * @param input Card Index value.
     * @return Card value as integer.
     */
    public static int getCardValue(int input) {
        return getSabaccValue(input);
    }

    /**
     * Private method that stores a switch statement of string literals that
     * are used to output to console based on passed through value (usually
     * the cardIndex value)
     * @param input Card index value.
     * @return Integer value on card index.
     */
    private static String getSuitsString(int input) {
        String value;
        
        switch(input) {
            case 0:
                value = "\u2663";
                break;
            case 1:
                value = "\u2666";
                break;
            case 2:
                value = "\u2665";
                break;
            case 3:
                value = "\u2660";
                break;
            default:
                value = "NULL";
                break;

        }
        
        return value;
    }

    /**
     * Private method that stores a switch statement of string literals that
     * are used to output to console based on passed through value (usually
     * the cardIndex value)
     * @param input Card index value.
     * @return Integer value on card index.
     */
    private static String getSabaccString(int input) {
        
        String value;
        
        switch(input) {
            case 0:
                value = "The Idiot " + suitFaceCards;
                break;
            case 1:
                value = "The Star " + suitFaceCards;
                break;
            case 2:
                value = "The Evil One " + suitFaceCards;
                break;
            case 3:
                value = "Moderation " + suitFaceCards;
                break;
            case 4:
                value = "Demise " + suitFaceCards;
                break;
            case 5:
                value = "Balance " + suitFaceCards;
                break;
            case 6:
                value = "Endurance " + suitFaceCards;
                break;
            case 7:
                value = "Queen of A&D " + suitFaceCards;
                break;
            case 8:
                value = "1 " + suitCoins;
                break;
            case 9:
                value = "2 " + suitCoins;
                break;
            case 10:
                value = "3 " + suitCoins;
                break;
            case 11:
                value = "4 " + suitCoins;
                break;
            case 12:
                value = "5 " + suitCoins;
                break;
            case 13:
                value = "6 " + suitCoins;
                break;
            case 14:
                value = "7 " + suitCoins;
                break;
            case 15:
                value = "8 " + suitCoins;
                break;
            case 16:
                value = "9 " + suitCoins;
                break;
            case 17:
                value = "10 " + suitCoins;
                break;
            case 18:
                value = "11 " + suitCoins;
                break;
            case 19:
                value = "C " + suitCoins;
                break;
            case 20:
                value = "MS " + suitCoins;
                break;
            case 21:
                value = "MR " + suitCoins;
                break;
            case 22:
                value = "A " + suitCoins;
                break;
            case 23:
                value = "1 " + suitFlasks;
                break;
            case 24:
                value = "2 " + suitFlasks;
                break;
            case 25:
                value = "3 " + suitFlasks;
                break;
            case 26:
                value = "4 " + suitFlasks;
                break;
            case 27:
                value = "5 " + suitFlasks;
                break;
            case 28:
                value = "6 " + suitFlasks;
                break;
            case 29:
                value = "7 " + suitFlasks;
                break;
            case 30:
                value = "8 " + suitFlasks;
                break;
            case 31:
                value = "9 " + suitFlasks;
                break;
            case 32:
                value = "10 " + suitFlasks;
                break;
            case 33:
                value = "11 " + suitFlasks;
                break;
            case 34:
                value = "C " + suitFlasks;
                break;
            case 35:
                value = "MS " + suitFlasks;
                break;
            case 36:
                value = "MR " + suitFlasks;
                break;
            case 37:
                value = "A " + suitFlasks;
                break;
            case 38:
                value = "1 " + suitSabres;
                break;
            case 39:
                value = "2 " + suitSabres;
                break;
            case 40:
                value = "3 " + suitSabres;
                break;
            case 41:
                value = "4 " + suitSabres;
                break;
            case 42:
                value = "5 " + suitSabres;
                break;
            case 43:
                value = "6 " + suitSabres;
                break;
            case 44:
                value = "7 " + suitSabres;
                break;
            case 45:
                value = "8 " + suitSabres;
                break;
            case 46:
                value = "9 " + suitSabres;
                break;
            case 47:
                value = "10 " + suitSabres;
                break;
            case 48:
                value = "11 " + suitSabres;
                break;
            case 49:
                value = "C " + suitSabres;
                break;
            case 50:
                value = "MS " + suitSabres;
                break;
            case 51:
                value = "MR " + suitSabres;
                break;
            case 52:
                value = "A " + suitSabres;
                break;
            case 53:
                value = "1 " + suitStaves;
                break;
            case 54:
                value = "2 " + suitStaves;
                break;
            case 55:
                value = "3 " + suitStaves;
                break;
            case 56:
                value = "4 " + suitStaves;
                break;
            case 57:
                value = "5 " + suitStaves;
                break;
            case 58:
                value = "6 " + suitStaves;
                break;
            case 59:
                value = "7 " + suitStaves;
                break;
            case 60:
                value = "8 " + suitStaves;
                break;
            case 61:
                value = "9 " + suitStaves;
                break;
            case 62:
                value = "10 " + suitStaves;
                break;
            case 63:
                value = "11 " + suitStaves;
                break;
            case 64:
                value = "C " + suitStaves;
                break;
            case 65:
                value = "MS " + suitStaves;
                break;
            case 66:
                value = "MR " + suitStaves;
                break;
            case 67:
                value = "A " + suitStaves;
                break;
            case 68:
                value = "Queen of A&D " + suitFaceCards;
                break;
            case 69:
                value = "Endurance " + suitFaceCards;
                break;
            case 70:
                value = "Balance " + suitFaceCards;
                break;
            case 71:
                value = "Demise " + suitFaceCards;
                break;
            case 72:
                value = "Moderation " + suitFaceCards;
                break;
            case 73:
                value = "The Evil One " + suitFaceCards;
                break;
            case 74:
                value = "The Star " + suitFaceCards;
                break;
            case 75:
                value = "The Idiot " + suitFaceCards;
                break;
            default:
                value = "NULL";
                break;
        }
        
        return value;
    }
    
    /**
     * Private method that stores a switch statement of integer values that
     * are used to calculate hand values.
     * @param input Card index value.
     * @return Integer value on card index.
     */
    private static int getSabaccValue(int input) {
        
        int value;
        
        switch(input) {
            case 0:
                value = 0;
                break;
            case 1:
                value = -17;
                break;
            case 2:
                value = -15;
                break;
            case 3:
                value = -14;
                break;
            case 4:
                value = -13;
                break;
            case 5:
                value = -11;
                break;
            case 6:
                value = -8;
                break;
            case 7:
                value = -2;
                break;
            case 8:
                value = 1;
                break;
            case 9:
                value = 2;
                break;
            case 10:
                value = 3;
                break;
            case 11:
                value = 4;
                break;
            case 12:
                value = 5;
                break;
            case 13:
                value = 6;
                break;
            case 14:
                value = 7;
                break;
            case 15:
                value = 8;
                break;
            case 16:
                value = 9;
                break;
            case 17:
                value = 10;
                break;
            case 18:
                value = 11;
                break;
            case 19:
                value = 12;
                break;
            case 20:
                value = 13;
                break;
            case 21:
                value = 14;
                break;
            case 22:
                value = 15;
                break;
            case 23:
                value = 1;
                break;
            case 24:
                value = 2;
                break;
            case 25:
                value = 3;
                break;
            case 26:
                value = 4;
                break;
            case 27:
                value = 5;
                break;
            case 28:
                value = 6;
                break;
            case 29:
                value = 7;
                break;
            case 30:
                value = 8;
                break;
            case 31:
                value = 9;
                break;
            case 32:
                value = 10;
                break;
            case 33:
                value = 11;
                break;
            case 34:
                value = 12;
                break;
            case 35:
                value = 13;
                break;
            case 36:
                value = 14;
                break;
            case 37:
                value = 15;
                break;
            case 38:
                value = 1;
                break;
            case 39:
                value = 2;
                break;
            case 40:
                value = 3;
                break;
            case 41:
                value = 4;
                break;
            case 42:
                value = 5;
                break;
            case 43:
                value = 6;
                break;
            case 44:
                value = 7;
                break;
            case 45:
                value = 8;
                break;
            case 46:
                value = 9;
                break;
            case 47:
                value = 10;
                break;
            case 48:
                value = 11;
                break;
            case 49:
                value = 12;
                break;
            case 50:
                value = 13;
                break;
            case 51:
                value = 14;
                break;
            case 52:
                value = 15;
                break;
            case 53:
                value = 1;
                break;
            case 54:
                value = 2;
                break;
            case 55:
                value = 3;
                break;
            case 56:
                value = 4;
                break;
            case 57:
                value = 5;
                break;
            case 58:
                value = 6;
                break;
            case 59:
                value = 7;
                break;
            case 60:
                value = 8;
                break;
            case 61:
                value = 9;
                break;
            case 62:
                value = 10;
                break;
            case 63:
                value = 11;
                break;
            case 64:
                value = 12;
                break;
            case 65:
                value = 13;
                break;
            case 66:
                value = 14;
                break;
            case 67:
                value = 15;
                break;
            case 68:
                value = -2;
                break;
            case 69:
                value = -8;
                break;
            case 70:
                value = -11;
                break;
            case 71:
                value = -13;
                break;
            case 72:
                value = -14;
                break;
            case 73:
                value = -15;
                break;
            case 74:
                value = -17;
                break;
            case 75:
                value = 0;
                break;
            default:
                value = 113;
                break;
        }
        
        return value;
    }
}