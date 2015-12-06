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

    public static final String WORD_BOUNDARY = "\\b";
    public static final String NOT_AT_END = "(?!$)";

    /**
     * Used for creating regex for splitting with delimiter keeping the delimiter
     *
     * @param delimiter Delimiter to split with
     * @return Regex to split with delimiter
     */
    public static String withDelimiter(String delimiter) {

        return "((?=" + delimiter + ")|(?<=" + delimiter + "))";
    }

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


    public static List<String> findAllMatches(String string, String regex) {

        return findAllMatches(string, regex, Matcher::group);
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
}
