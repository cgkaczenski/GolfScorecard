package com.teamtreehouse.golfscorecard;

public class Hole {
    private int mHole;
    private int mStroke;

    public Hole(int hole, int stroke) {
        mHole = hole;
        mStroke = stroke;
    }

    public int getHole() {
        return mHole;
    }

    public void setHole(int hole) {
        mHole = hole;
    }

    public int getStroke() {
        return mStroke;
    }

    public void setStroke(int stroke) {
        mStroke = stroke;
    }
}
