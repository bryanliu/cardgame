package com.bryan.cardgame;

import java.util.Arrays;
import java.util.List;

import com.bryan.cardgame.entity.CardDeck;
import com.bryan.cardgame.entity.Player;

public class CardGame {

    public static void main(String[] args) {

        CardDeck deck = CardDeck.getInstance();
        deck.shuffle();

        Player p1 = new Player("Tom");
        Player p2 = new Player("Jerry");
        Player p3 = new Player("Brutto");

        List<Player> players = Arrays.asList(p1, p2, p3);

        for (int round = 1; round <= 19; round++) {

            boolean hasWinner = false;

            //Deal
            for (Player p : players) {

                p.receiveCard(deck.deal());

            }

            //Check
            for (Player p : players) {

                if (p.win()) {
                    System.out.println("Round " + round + " " + p + " is the winner, card list is " + p.getCardList());
                    hasWinner = true;
                    break;

                }

            }

            if (hasWinner) {
                break;
            }

        }

    }
}
