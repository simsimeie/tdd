package org.chap08.java.testable;



import org.chap08.java.subs.Product;
import org.chap08.java.subs.ProductDao;

import java.util.HashMap;
import java.util.Map;

public class MemoryProductDao implements ProductDao {
    private Map<String, Product> prds = new HashMap<>();

    @Override
    public Product selectById(String productId) {
        return null;
    }
}
