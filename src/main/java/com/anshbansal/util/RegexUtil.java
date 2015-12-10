package com.anshbansal.util;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexUtil {

    //////////// For getting regex for larger regular expressions
    public static final String NOT_AT_END = "(?!$)";

    ////////////  Functions

    static BiFunction<Matcher, List<Integer>, List<String>> allNotNullGroups =
            (matcher, integers) -> integers.stream()
                    .map(matcher::group)
                    .filter(i -> i != null)
                    .collect(Collectors.toList());

    ////////////  Utilities for calculating regex

    public static Matcher getMatcher(String string, String regex) {

        return Pattern.compile(regex).matcher(string);
    }

    public static List<String> findAllMatches(
            String string,
            String regex,
            List<Integer> groupNumbers
    ) {
        Matcher matcher = getMatcher(string, regex);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.addAll(allNotNullGroups.apply(matcher, groupNumbers));
        }
        return result;
    }

    public static List<String> findAllMatches(
            String string,
            String regex,
            int groupNumber
    ) {
        return findAllMatches(string, regex, matcher -> matcher.group(groupNumber));
    }

    public static List<String> findAllMatches(
            String string,
            String regex,
            Function<Matcher, String> function
    ) {
        Matcher matcher = getMatcher(string, regex);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(function.apply(matcher));
        }
        return result;
    }

    public static String replace(
            String string,
            String regex,
            Function<Matcher, String> replaceFunction
    ) {
        Matcher matcher = RegexUtil.getMatcher(string, regex);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(sb, replaceFunction.apply(matcher));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
