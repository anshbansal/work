package com.anshbansal.ds.map

import spock.lang.Specification

class Key2HashMapTest extends Specification {

    def "test that can get and put values in Key2HashMap"() {
        Key2Map<String, String, Integer> map = new Key2HashMap()
    when:
        map.put("aseem", "bansal", 25)
    then:
        map.get("aseem", "bansal") == 25
    }

    def "test that when nothing is added we do not get an exception"() {
        Key2Map<String, String, Integer> map = new Key2HashMap<>()
    expect:
        map.get("aseem", "bansal") == null
    }

}