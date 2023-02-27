package org.chap06.domain;

import org.chap06.exception.InAppropriateException;
import org.chap06.exception.ThreeOutChangeException;

public class BaseballGame {
    private String secret;
    private int outCount=0;
    private static final int MAX_OUT_COUNT = 3;
    private final int SECRET_LENGTH = 3;

    public BaseballGame(String secret){
        this.secret = secret;
        this.outCount = 0;
    }

    public Score play(String tried){
        checkThreeOut();
        checkInAppropriation(tried);
        Score score = judgeStrikeOrBall(tried);
        judgeOut(score);

        return score;
    }

    private void checkThreeOut() {
        if(outCount >= MAX_OUT_COUNT) throw new ThreeOutChangeException();
    }

    private void checkInAppropriation(String tried) {
        if(null == tried) throw new InAppropriateException();
        if(tried.length() < SECRET_LENGTH || tried.length() > SECRET_LENGTH) throw new InAppropriateException();
        for(char ch : tried.toCharArray()){
            if(ch < '0' || ch > '9') throw new InAppropriateException();
        }
    }

    private Score judgeStrikeOrBall(String tried){
        int strikes = 0;
        int balls = 0;

        for(int i=0; i < SECRET_LENGTH; i++) {
            for (int j = 0; j < SECRET_LENGTH; j++) {
                if (secret.charAt(i) == tried.charAt(j)) {
                    if (i == j)  strikes++;
                    else  balls++;
                    break;
                }
            }
        }

        return new Score(strikes, balls);
    }

    private void judgeOut(Score score){
        if(score.getStrikes() == 0 && score.getBalls() == 0) outCount++;
    }


    public int getOutCount() {
        return outCount;
    }

    public void setOutCount(int outCount) {
        this.outCount = outCount;
    }
}
