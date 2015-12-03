package com.anshbansal.recepies.regex;

import com.anshbansal.util.RegexUtil;

import java.util.List;

public class RegexExamples {

    static List<String> insideDoubleSquareBrackets(String str) {
        String regex = "\\[\\[(.*?)]]";
        return RegexUtil.findAllMatches(str, regex, 1);
    }

    static String replaceConsecutivesDuplicatesByOne(String str) {
        String regex = "(.)\\1+";
        return str.replaceAll(regex, "$1");
    }
}
