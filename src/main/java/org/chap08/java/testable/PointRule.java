package org.chap08.java.testable;


import org.chap08.java.subs.Product;
import org.chap08.java.subs.Subscription;

import java.time.LocalDate;

import static org.chap08.java.subs.Grade.GOLD;

public class PointRule {

    public int calculate(Subscription s, Product p, LocalDate now) {
        int point = 0;
        if (s.isFinished(now)) {
            point += p.getDefaultPoint();
        } else {
            point += p.getDefaultPoint() + 10;
        }
        if (s.getGrade() == GOLD) {
            point += 100;
        }
        return point;
    }
}
