package org.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PasswordStrengthMeterTest {
    @Test
    public void meetsAllCriteria_Then_Strong(){
        PasswordStrengthMeter passwordStrengthMeter = new PasswordStrengthMeter();
        assertEquals(PasswordStrength.STRONG, passwordStrengthMeter.meter("ab12!@AB"));

    }
}
