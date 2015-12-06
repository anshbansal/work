package com.anshbansal.ds.map;

public interface Key2Map<K1, K2, R> {

    public R get(K1 key1, K2 key2);
    public void put(K1 key1, K2 key2, R value);

}
