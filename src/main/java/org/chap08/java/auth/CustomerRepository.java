package org.chap08.java.auth;

public interface CustomerRepository {
    Customer findOne(String id);
}
