package com.anshbansal.recepies.regex;

public class BadRegexExamples {

    /**
     * Greater than any number
     */
    public static boolean greaterThan75(String str) {
        String regex = "7[6-9]|[8-9][0-9]|[1-9][0-9]{2,}";
        return str.matches(regex);
    }
}
