package com.teamtreehouse.golfscorecard;

public class Hole {
    private int mHole;
    private int mScore;

    public Hole(int hole, int score) {
        mHole = hole;
        mScore = score;
    }

    public int getHole() {
        return mHole;
    }

    public void setHole(int hole) {
        mHole = hole;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
}
