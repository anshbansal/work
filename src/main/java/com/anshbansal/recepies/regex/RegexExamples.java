package com.anshbansal.recepies.regex;

import com.anshbansal.util.Regex;

import java.util.List;

public class RegexExamples {

    static List<String> insideDoubleSquareBrackets(String str) {
        String regex = "\\[\\[(.*?)]]";
        return Regex.findAllMatches(str, regex, 1);
    }
}
