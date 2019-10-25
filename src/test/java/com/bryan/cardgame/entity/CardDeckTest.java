package com.bryan.cardgame.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.bryan.cardgame.exception.CardNotShufflerException;

public class CardDeckTest {

    @Test
    public void test_deal_success() {

        CardDeck d = CardDeck.getInstance();

        assertEquals(0, d.availableCards.size());

        d.availableCards.add(Card.CARD_A);
        d.availableCards.add(Card.CARD_K);

        assertEquals(2, d.availableCards.size());

        Card c = d.deal();
        assertNotNull(c);
        assertEquals(1, d.availableCards.size());

        c = d.deal();
        assertNotNull(c);
        assertEquals(0, d.availableCards.size());

    }

    @Test(expected = CardNotShufflerException.class)
    public void test_deal_before_shuffler() {

        CardDeck d = CardDeck.getInstance();

        assertEquals(0, d.availableCards.size());

        Card c = d.deal();
    }

    @Test
    public void test_shuffle() {

        CardDeck d = CardDeck.getInstance();

        assertEquals(0, d.availableCards.size());

        d.shuffle();

        System.out.println(d.availableCards);

        assertEquals(54, d.availableCards.size());

        assertEquals(Card.CARD_A.getCount(), d.getCardCount(Card.CARD_A));
        assertEquals(Card.CARD_4.getCount(), d.getCardCount(Card.CARD_4));
        assertEquals(Card.CARD_9.getCount(), d.getCardCount(Card.CARD_9));
        assertEquals(Card.CARD_J.getCount(), d.getCardCount(Card.CARD_J));
        assertEquals(Card.CARD_BLACK_JOKE.getCount(), d.getCardCount(Card.CARD_BLACK_JOKE));

    }
}