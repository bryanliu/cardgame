package com.bryan.cardgame.entity;

import static com.bryan.cardgame.entity.Card.CARD_10;
import static com.bryan.cardgame.entity.Card.CARD_A;
import static com.bryan.cardgame.entity.Card.CARD_K;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void test_receiveCard_success() {

        Player p = new Player("a");

        Assert.assertEquals(0, p.cardList.size());

        p.receiveCard(CARD_A);

        Assert.assertEquals(1, p.cardList.size());

    }

    @Test
    public void test_receiveCard_fail() {

        Player p = new Player("a");

        p.receiveCard(null);
        Assert.assertEquals(0, p.cardList.size());

    }

    @Test
    public void test_win_win() {

        Player p = new Player("a");
        p.receiveCard(CARD_K);
        p.receiveCard(CARD_K);
        assertFalse(p.win());

        p.receiveCard(CARD_K);
        p.receiveCard(CARD_10);
        assertFalse(p.win());

        p.receiveCard(CARD_A);
        assertFalse(p.win());

        //Bigger then 50, win
        p.receiveCard(CARD_A);
        assertTrue(p.win());

    }
}
