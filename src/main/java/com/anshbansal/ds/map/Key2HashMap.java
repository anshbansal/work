package com.anshbansal.ds.map;

import java.util.HashMap;
import java.util.Map;

public class Key2HashMap<K1, K2, R> implements Key2Map<K1, K2, R> {

    private Map<K1, Map<K2, R>> map = new HashMap<>();

    @Override
    public R get(K1 key1, K2 key2) {
        Map<K2, R> key2Map = map.get(key1);
        if (key2Map == null) {
            return null;
        }
        return key2Map.get(key2);
    }

    @Override
    public void put(K1 key1, K2 key2, R value) {

        Map<K2, R> key2Map = map.computeIfAbsent(key1, k -> new HashMap<>());
        key2Map.put(key2, value);
    }
}
