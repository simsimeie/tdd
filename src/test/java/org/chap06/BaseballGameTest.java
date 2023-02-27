package org.chap06;

import org.chap06.domain.BaseballGame;
import org.chap06.domain.Score;
import org.chap06.exception.InAppropriateException;
import org.chap06.exception.ThreeOutChangeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    private static BaseballGame baseballGame;
    private static final String testSecret = "123";
    @BeforeEach
    public void init(){
        baseballGame = new BaseballGame(testSecret);
    }

    @Test
    @DisplayName("Three out 이면, Exception이 발생하는지 테스트")
    public void three_out_exception_test(){
        //given
        baseballGame.setOutCount(3);
        //when
        //then
        assertThrows(ThreeOutChangeException.class, () -> baseballGame.play("123"));
    }

    @Test
    @DisplayName("부적합한 input이 들어오면 Exception이 발생하는지 테스트")
    public void inAppropriate_input_test(){
        //given
        //when - null이 들어올 때
        //then
        assertThrows(InAppropriateException.class, () -> baseballGame.play(null));
        //when - 3자리 미만이 들어올 때
        //then
        assertThrows(InAppropriateException.class, () -> baseballGame.play("12"));
        //when - 3자리 초과가 들어올 때
        //then
        assertThrows(InAppropriateException.class, () -> baseballGame.play("1234"));
        //when - 숫자 외의 값이 들어올 때
        //then
        assertThrows(InAppropriateException.class, () -> baseballGame.play("a2A"));
    }

    @Test
    @DisplayName("3 strike 리턴하는지 테스트")
    public void threeStrike_test(){
        //given
        String tried = "123";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(3, score.getStrikes());
    }

    @Test
    @DisplayName("2 strike 리턴하는지 테스트")
    public void twoStrike_test(){
        //given
        String tried = "193";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(2, score.getStrikes());
    }

    @Test
    @DisplayName("1 strike 리턴하는지 테스트")
    public void oneStrike_test(){
        //given
        String tried = "199";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(1, score.getStrikes());
    }


    @Test
    @DisplayName("3 ball 리턴하는지 테스트")
    public void threeBall_test(){
        //given
        String tried = "312";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(3, score.getBalls());
    }

    @Test
    @DisplayName("2 ball 리턴하는지 테스트")
    public void twoBall_test(){
        //given
        String tried = "319";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(2, score.getBalls());
    }

    @Test
    @DisplayName("1 ball 리턴하는지 테스트")
    public void oneBall_test(){
        //given
        String tried = "399";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(1, score.getBalls());
    }


    @Test
    @DisplayName("1 strike 1 ball 리턴하는지 테스트")
    public void oneStrike_oneBall_test(){
        //given
        String tried = "139";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(1, score.getStrikes());
        assertEquals(1, score.getBalls());
    }

    @Test
    @DisplayName("1 strike 2 ball 리턴하는지 테스트")
    public void oneStrike_twoBall_test(){
        //given
        String tried = "132";
        //when
        Score score = baseballGame.play(tried);
        //then
        assertEquals(1, score.getStrikes());
        assertEquals(2, score.getBalls());
    }


    @Test
    @DisplayName("out 테스트")
    public void out_test(){
        //given
        String tried = "456";
        //when
        baseballGame.play(tried);
        //then
        assertEquals(1, baseballGame.getOutCount());
    }


}