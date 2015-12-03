package com.anshbansal.recepies.regex;

import com.anshbansal.util.RegexUtil;

import java.util.List;

public class RegexExamples {

    static List<String> insideDoubleSquareBrackets(String str) {
        String regex = "\\[\\[(.*?)]]";
        return RegexUtil.findAllMatches(str, regex, 1);
    }

    static String replaceConsecutiveDuplicatesByOne(String str) {
        String regex = "(.)\\1+";
        return str.replaceAll(regex, "$1");
    }

    static String removeBrackets(String str) {
        //TODO Need to see why need to escape brackets
        String regex = "[\\(\\)\\{\\}\\[\\]]";
        return str.replaceAll(regex, "");
    }
}
