package org.chap08.java.testable;


import org.chap08.java.payinfo.PayInfo;
import org.chap08.java.payinfo.PayInfoDao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MemoryPayInfoDao extends PayInfoDao {
    private LinkedHashMap<String, PayInfo> infos = new LinkedHashMap<>();
    @Override
    public void insert(PayInfo pi) {
        infos.put(pi.getTrNum(), pi);
    }

    public List<PayInfo> getAll() {
        return new ArrayList<>(infos.values());
    }
}
