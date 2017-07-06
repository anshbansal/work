package com.anshbansal.ds.map;

public interface Key2Map<K1, K2, R> {

    R get(K1 key1, K2 key2);
    void put(K1 key1, K2 key2, R value);

}
