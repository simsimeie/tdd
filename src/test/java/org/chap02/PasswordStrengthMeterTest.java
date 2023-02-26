package org.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter();

    @Test
    public void meetsAllCriteria_Then_Strong(){
        assertEquals(PasswordStrength.STRONG, passwordStrengthMeter.meter("ab12!@AB"));
        assertEquals(PasswordStrength.STRONG, passwordStrengthMeter.meter("abc1!Add"));
    }

    @Test
    public void meetsOtherCriteria_except_for_Length_Then_Noraml(){
        PasswordStrength meter = passwordStrengthMeter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, meter);
    }

    @Test
    public void meetsOtherCriteria_except_for_number_Then_Noraml(){
        PasswordStrength meter = passwordStrengthMeter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, meter);
    }

    @Test
    public void nullInput_Then_Invalid(){
        PasswordStrength meter = passwordStrengthMeter.meter(null);
        assertEquals(PasswordStrength.INVALID, meter);
        meter = passwordStrengthMeter.meter("");
        assertEquals(PasswordStrength.INVALID, meter);
    }

    @Test
    public void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        PasswordStrength meter = passwordStrengthMeter.meter("ab12!@df");
        assertEquals(PasswordStrength.NORMAL, meter);
    }

    @Test
    public void meetsOnlyLengthCriteria_Then_Weak(){
        PasswordStrength meter = passwordStrengthMeter.meter("abcdefgh");
        assertEquals(meter, PasswordStrength.WEAK);
    }

    @Test
    public void meetsOnlyUpperCriteria_Then_Weak(){
        PasswordStrength meter = passwordStrengthMeter.meter("ABZEF");
        assertEquals(meter, PasswordStrength.WEAK);
    }

    @Test
    public void meetsNoCriteria_Then_Weak(){
        PasswordStrength meter = passwordStrengthMeter.meter("abc");
        assertEquals(meter, PasswordStrength.WEAK);
    }
}
