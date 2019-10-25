package com.bryan.cardgame.entity;

public enum Card {

    CARD_A("A", 1, 4),
    CARD_2("2", 2, 4),
    CARD_3("3", 3, 4),
    CARD_4("4", 4, 4),
    CARD_5("5", 5, 4),
    CARD_6("6", 6, 4),
    CARD_7("7", 7, 4),
    CARD_8("8", 8, 4),
    CARD_9("9", 9, 4),
    CARD_10("10", 10, 4),
    CARD_J("J", 11, 4),
    CARD_Q("Q", 12, 4),
    CARD_K("K", 13, 4),
    CARD_BLACK_JOKE("Black Joke", 20, 1),
    CARD_RED_JOKE("Red Joke", 20, 1),
    ;

    private String card;

    private int score;

    private int count;

    Card(String name, int score, int count) {
        this.card = name;
        this.score = score;
        this.count = count;

    }

    public String getCard() {
        return card;
    }

    public int getScore() {
        return score;
    }

    public int getCount() {
        return count;
    }
}
