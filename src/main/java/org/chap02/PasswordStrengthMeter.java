package org.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s){
        if(null == s || "".equals(s)) return PasswordStrength.INVALID;

        int metCount = 0;

        if(s.length() >= 8) metCount++;
        if(isContainsNum(s)) metCount++;
        if(isContainsUpp(s)) metCount++;

        if(metCount <= 1) return PasswordStrength.WEAK;
        if(metCount == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private boolean isContainsUpp(String s) {
        boolean containsUpp = false;
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                containsUpp = true;
                break;
            }
        }
        return containsUpp;
    }

    private boolean isContainsNum(String s) {
        boolean containsNum = false;
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                containsNum = true;
                break;
            }
        }
        return containsNum;
    }
}
