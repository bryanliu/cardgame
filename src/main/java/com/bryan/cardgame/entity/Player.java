package com.bryan.cardgame.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {

    static final int WINNING_SCORE = 50;

    /**
     * Store the card send to player
     */
    List<Card> cardList = new ArrayList<Card>();

    /**
     * Store the total score for all owned card
     */
    private int totalCount = 0;

    /**
     * Store the name of the player
     */
    private String name;

    public Player(String name) {

        this.name = name;

    }

    /**
     * Receive card from dealer
     *
     * @param card
     */
    public void receiveCard(Card card) {

        if (card != null) {

            cardList.add(card);
            totalCount += card.getScore();
        }

    }

    /**
     * Return the result for
     *
     * @return true if total score larger then winning score
     */
    public boolean win() {

        if (totalCount > WINNING_SCORE) {
            return true;
        }

        return false;

    }

    @Override public String toString() {
        return "Player{" +
                "totalCount=" + totalCount +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Return card this player owned
     * @return cards
     */
    public List<Card> getCardList() {

        return cardList;
    }
}
