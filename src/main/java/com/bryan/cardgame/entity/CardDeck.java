package com.bryan.cardgame.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bryan.cardgame.exception.CardNotShufflerException;

/**
 * Card deck is used to deal 54 cards in random
 */
public class CardDeck {

    static CardDeck cardDeck = null;

    List<Card> availableCards = Collections.synchronizedList(new ArrayList<Card>());

    private CardDeck() {

    }

    /**
     * Get instance of card deck
     *
     * @return card deck
     */
    public static CardDeck getInstance() {

        if (cardDeck == null) {

            return new CardDeck();

        }

        return cardDeck;

    }

    /**
     * Dear cards
     *
     * @return Cards in available cards
     */
    public Card deal() {
        if (availableCards.isEmpty()) {
            throw new CardNotShufflerException("Card Deck is empty, need shuffler the card and reload first");
        }

        Card topCard = availableCards.get(0);
        availableCards.remove(0);

        return topCard;

    }

    /**
     * Shuffler the cards before play the game
     */
    public void shuffle() {

        List<Thread> threadList = new ArrayList<Thread>();

        for (Card c : Card.values()) {

            Thread t = new ShufflerCard(c);

            t.start();

            threadList.add(t);

        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Collections.shuffle(availableCards);

    }

    /**
     * Return card counts for card in current available cards
     *
     * @param card
     * @return available counts
     */
    public int getCardCount(Card card) {

        int count = 0;

        if (card == null) {
            return 0;
        }

        for (Card ca : availableCards) {

            if (card.equals(ca)) {

                count++;

            }

        }

        return count;

    }

    class ShufflerCard extends Thread {

        private Card card;

        public ShufflerCard(Card card) {
            this.card = card;
        }

        public void run() {

            for (int i = 0; i < card.getCount(); i++) {
                System.out.println(Thread.currentThread().getName() + "is running");
                availableCards.add(card);

            }

        }
    }

}
