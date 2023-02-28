package org.chap08;

import org.chap08.java.testable.DailyBatchLoader;
import org.chap08.java.testable.Times;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.time.LocalDate;

public class DailyBatchLoaderTest {
    private Times mockTimes = Mockito.mock(Times.class);
    private final DailyBatchLoader loader = new DailyBatchLoader();

    @BeforeEach
    void setUp() {
        loader.setBasePath("src/test/resources");
        loader.setTimes(mockTimes);
    }

    @Test
    void loadCount() {
        BDDMockito.given(mockTimes.today()).willReturn(LocalDate.of(2019, 1, 1));

        int ret = loader.load();

        Assertions.assertEquals(3, ret);
    }
}
