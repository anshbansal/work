package com.anshbansal.recepies.regex;

import com.anshbansal.util.RegexUtil;

import java.util.Arrays;
import java.util.List;

public class RegexExamples {

    /****** GENERIC METHODS ******/

    public static String[] splitAndKeepDelimiters(String str, String delimiter) {
        String regex = "((?=" + delimiter + ")|(?<=" + delimiter + "))";
        return str.split(regex);
    }

    /****** SPECIFIC METHODS ******/

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

    static String[] splitKeepingNumbersTogether(String str) {
        return splitAndKeepDelimiters(str, "\\D");
    }

    static List<String> findAllComments(String str) {
        String regex = "(?-s://(.*))|(?s:/\\*(.*?)\\*/)";
        return RegexUtil.findAllMatches(str, regex, Arrays.asList(1, 2));
    }

    static String enterADelimiter(String str, String delimiter, int after) {
        String regex = String.format("(.{%d})%s", after, RegexUtil.NOT_AT_END);
        String replacement = "$1" + delimiter;

        return str.replaceAll(regex, replacement);
    }

    static String hyphenToCamelCase(String str) {
        String regex = "(?:^|-)([^-])";

        return RegexUtil.replace(
                str,
                regex,
                matcher -> matcher.group(1).toUpperCase()
        );
    }
}
