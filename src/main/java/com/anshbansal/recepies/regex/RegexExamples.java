package com.anshbansal.recepies.regex;

import com.anshbansal.util.RegexUtil;

import java.util.Arrays;
import java.util.List;

public class RegexExamples {

    ///////////NOTES
    /*
\d  digit
\w  letters, digits, _      U for unicode
\s  whitespace

(?-m)^  - start of line
(?-m)$  - end of line
\A      - start of subject
\Z      - end of subject
\b      - word boundaries   Always unicode

FLAGS
(?d) UNIX LINES
(?i) CASE_INSENSITIVE
(?x) COMMENTS
(?m) MULTILINE
     LITERAL
(?s) DOTALL
(?u) UNICODE_CASE
     CANON_EQ
(?U) UNICODE_CHARACTER_CLASS

GROUPS
()      Group
(?:)    Non-capturing group
(?<>)   Named capturing group
(?>)    Atomic group

LOOK-AROUND
(?<=)   Positive Lookbehind
(?=)    Positive Lookahead
(?<!)   Negative lookbehind
(?!)    Negative lookahead
*/

    /****** GENERIC METHODS ******/

    static String[] splitAndKeepDelimiters(String str, String delimiter) {
        return str.split(RegexUtil.withDelimiter(delimiter));
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
