package com.playtika.challenge4.models;

public enum BingoNumberColumn {
    B(1,15),
    I(16,30),
    N(31,45),
    G(46,60),
    O(61,75);

    private int lowVal;
    private int highVal;

    BingoNumberColumn(int lowVal, int highVal) {
        this.lowVal = lowVal;
        this.highVal = highVal;
    }

    public int getLowVal() {
        return lowVal;
    }

    public int getHighVal() {
        return highVal;
    }
}
