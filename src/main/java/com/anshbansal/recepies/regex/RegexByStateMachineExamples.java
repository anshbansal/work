package com.anshbansal.recepies.regex;

import java.util.ArrayList;
import java.util.List;

public class RegexByStateMachineExamples {

    static List<String> splitByCommaButIgnoreInQuotes(String str) {

        List<String> result = new ArrayList<>();
        int start = 0;
        boolean inQuotes = false;
        for (int current = 0; current < str.length(); current++) {
            if (str.charAt(current) == '\"') {
                inQuotes = !inQuotes;
            }
            boolean atLastChar = (current == str.length() - 1);
            if (atLastChar) {
                result.add(str.substring(start));
            } else if (str.charAt(current) == ',' && !inQuotes) {
                result.add(str.substring(start, current));
                start = current + 1;
            }
        }
        return result;
    }
}
