package org.chap08;

import org.chap08.java.payinfo.PayInfo;
import org.chap08.java.testable.MemoryPayInfoDao;
import org.chap08.java.testable.PaySync;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaySyncTest {
    private MemoryPayInfoDao memoryDao = new MemoryPayInfoDao();

    @Test
    void allDataSaved() throws IOException {
        PaySync paySync = new PaySync();
        paySync.setPayInfoDao(memoryDao);
        paySync.setFilePath("src/test/resources/c0111.csv");

        paySync.sync();

        List<PayInfo> savedInfos = memoryDao.getAll();
        Assertions.assertEquals(2, savedInfos.size());
    }
}
