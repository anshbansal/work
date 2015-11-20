package com.anshbansal.util;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static final String WORD_BOUNDARY = "\\b";

    public static Matcher getMatcher(String string, String regex) {

        return Pattern.compile(regex).matcher(string);
    }


    public static List<String> findAllMatches(String string, String regex) {

        return findAllMatches(string, regex, Matcher::group);
    }

    public static List<String> findAllMatches(String string, String regex, int groupNumber) {

        return findAllMatches(string, regex, matcher -> matcher.group(groupNumber));
    }

    public static List<String> findAllMatches(String string, String regex,
                                              Function<Matcher, String> function) {

        Matcher matcher = getMatcher(string, regex);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(function.apply(matcher));
        }
        return result;
    }
}
