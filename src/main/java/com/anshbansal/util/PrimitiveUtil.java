package com.anshbansal.util;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveUtil {

    public static List<Character> toList(char[] chars) {

        List<Character> result = new ArrayList<>(chars.length);
        for (char elem : chars) {
            result.add(elem);
        }
        return result;
    }

}
