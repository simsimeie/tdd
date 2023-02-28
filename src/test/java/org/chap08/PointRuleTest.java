package org.chap08;


import org.chap08.java.subs.Grade;
import org.chap08.java.subs.Product;
import org.chap08.java.subs.Subscription;
import org.chap08.java.testable.PointRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

public class PointRuleTest {
    @Test
    void 만료전_GOLD등급은_130포인트() throws IOException {
        PointRule rule = new PointRule();
        Subscription s = new Subscription(
                "user",
                LocalDate.of(2019, 5, 5),
                Grade.GOLD);
        Product p = new Product("pid");
        p.setDefaultPoint(20);

        int point = rule.calculate(s, p, LocalDate.of(2019, 5, 1));

        Assertions.assertEquals(130, point);
    }
}
