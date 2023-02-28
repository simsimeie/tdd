package org.chap08.java.subs;

public interface SubscriptionDao {
    Subscription selectByUser(String id);

    void insert(Subscription subscription);
}
