/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapp;

import java.util.Comparator;

/**
 *
 * @author bluebackdev
 */
abstract public class CompareBySuit implements Comparator <Card> {
    public int compare(Card a, Card b) {
        return a.getCardValue() - b.getCardValue();
    }
}