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
public class Suit {
    public enum GameType {
        SUITS, SABACC
    }
    
    private static GameType gameType;
    
    private static int cardsInSuit;
    
    public static void setGameType(GameType gt) {
        gameType = gt;
        
        switch(gt) {
            case SUITS:
                cardsInSuit = 4;
                break;
            case SABACC:
                cardsInSuit = 76;
                break;
            default:
                cardsInSuit = -1;
                break;
        }
    }
    
    public static int getCardsInSuit() {
        return cardsInSuit;
    }
    
    public static String getCardValue(int input) {
        String value;
        
        switch(gameType) {
            case SUITS:
                value = getSuitsValue(input);
                break;
            case SABACC:
                value = getSabaccValue(input);
                break;
            default:
                value = "NULL";
                break;
        }
        
        return value;
    }

    private static String getSuitsValue(int input) {
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

    private static String getSabaccValue(int input) {
        
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
            case 4:
                value = "\u2663";
                break;
            case 5:
                value = "\u2666";
                break;
            case 6:
                value = "\u2665";
                break;
            case 7:
                value = "\u2660";
                break;
            case 8:
                value = "\u2663";
                break;
            case 9:
                value = "\u2666";
                break;
            case 10:
                value = "\u2665";
                break;
            case 11:
                value = "\u2660";
                break;
            case 12:
                value = "\u2663";
                break;
            case 13:
                value = "\u2666";
                break;
            case 14:
                value = "\u2665";
                break;
            case 15:
                value = "\u2660";
                break;
            case 16:
                value = "\u2663";
                break;
            case 17:
                value = "\u2666";
                break;
            case 18:
                value = "\u2665";
                break;
            case 19:
                value = "\u2660";
                break;
            case 20:
                value = "\u2663";
                break;
            case 21:
                value = "\u2666";
                break;
            case 22:
                value = "\u2665";
                break;
            case 23:
                value = "\u2660";
                break;
            case 24:
                value = "\u2663";
                break;
            case 25:
                value = "\u2666";
                break;
            case 26:
                value = "\u2665";
                break;
            case 27:
                value = "\u2660";
                break;
            case 28:
                value = "\u2663";
                break;
            case 29:
                value = "\u2666";
                break;
            case 30:
                value = "\u2665";
                break;
            case 31:
                value = "\u2660";
                break;
            case 32:
                value = "\u2663";
                break;
            case 33:
                value = "\u2666";
                break;
            case 34:
                value = "\u2665";
                break;
            case 35:
                value = "\u2660";
                break;
            case 36:
                value = "\u2663";
                break;
            case 37:
                value = "\u2666";
                break;
            case 38:
                value = "\u2665";
                break;
            case 39:
                value = "\u2660";
                break;
            case 40:
                value = "\u2663";
                break;
            case 41:
                value = "\u2666";
                break;
            case 42:
                value = "\u2665";
                break;
            case 43:
                value = "\u2660";
                break;
            case 44:
                value = "\u2663";
                break;
            case 45:
                value = "\u2666";
                break;
            case 46:
                value = "\u2665";
                break;
            case 47:
                value = "\u2660";
                break;
            case 48:
                value = "\u2663";
                break;
            case 49:
                value = "\u2666";
                break;
            case 50:
                value = "\u2665";
                break;
            case 51:
                value = "\u2660";
                break;
            case 52:
                value = "\u2663";
                break;
            case 53:
                value = "\u2666";
                break;
            case 54:
                value = "\u2665";
                break;
            case 55:
                value = "\u2660";
                break;
            case 56:
                value = "\u2663";
                break;
            case 57:
                value = "\u2666";
                break;
            case 58:
                value = "\u2665";
                break;
            case 59:
                value = "\u2660";
                break;
            case 60:
                value = "\u2663";
                break;
            case 61:
                value = "\u2666";
                break;
            case 62:
                value = "\u2665";
                break;
            case 63:
                value = "\u2660";
                break;
            case 64:
                value = "\u2665";
                break;
            case 65:
                value = "\u2660";
                break;
            case 66:
                value = "\u2663";
                break;
            case 67:
                value = "\u2666";
                break;
            case 68:
                value = "\u2665";
                break;
            case 69:
                value = "\u2660";
                break;
            case 70:
                value = "\u2663";
                break;
            case 71:
                value = "\u2666";
                break;
            case 72:
                value = "\u2665";
                break;
            case 73:
                value = "\u2660";
                break;
            case 74:
                value = "\u2663";
                break;
            case 75:
                value = "\u2666";
                break;
            default:
                value = "NULL";
                break;
        }
        
        return value;
    }
}
