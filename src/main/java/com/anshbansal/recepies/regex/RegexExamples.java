package com.anshbansal.recepies.regex;

import com.anshbansal.util.RegexUtil;

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

    static String[] splitAndKeepDelimiters(String str, String delimiter) {
        return str.split(RegexUtil.withDelimiter(delimiter));
    }

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
        //TODO Why check for not at beginning is needed? http://stackoverflow.com/questions/34103906/regex-for-splitting-at-brackets-signs-and-letters-keeping-numbers-together
        //String regex = "(?=\\D)|(?<=\\D)";
        return str.split(RegexUtil.withDelimiter("\\D"));
    }
}
