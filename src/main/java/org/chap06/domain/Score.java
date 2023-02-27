package org.chap06.domain;

public class Score {
    public Score() {
    }

    public Score(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    private int strikes;
    private int balls;

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
