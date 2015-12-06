package com.anshbansal.recepies.regex

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class RegexExamplesTest extends Specification {


    def "test that splitting #input with #delimiter returns #expected"() {

    expect:
        RegexExamples.splitAndKeepDelimiters(input, delimiter) == expected

    where:
        input | delimiter | expected
        ""      | ""  | [""]
        "a;b;c" | ";" | ["a", ";", "b", ";", "c"]
    }

    def "test that insideDoubleSquareBrackets( #input ) returns #expected"() {

    expect:
        RegexExamples.insideDoubleSquareBrackets(input) == expected

    where:
        input | expected
        ""                                | []
        "[[aseem]]"                       | ["aseem"]
        "foo[[aseem]]"                    | ["aseem"]
        "foo[[aseem]]bar"                 | ["aseem"]
        "foo[[aseem]]bar foo[[aseem]]bar" | ["aseem", "aseem"]
    }

    def "test that replaceConsecutiveDuplicates( #input ) returns #expected"() {

    expect:
        RegexExamples.replaceConsecutiveDuplicatesByOne(input) == expected

    where:
        input | expected
        ""         | ""
        "aaaa"     | "a"
        "aass"     | "as"
        "aaaaaaas" | "as"
        "asasas"   | "asasas"
    }

    def "test that #input after bracket removal becomes #expected"() {

    expect:
        RegexExamples.removeBrackets(input) == expected
    where:
        input | expected
        ""        | ""
        "("       | ""
        "()"      | ""
        "({{{}]]" | ""
        "abc"     | "abc"
    }

    def "test that after splitting #input keeping digits together we get #expected "() {

    expect:
        RegexExamples.splitKeepingNumbersTogether(input) == expected
    where:
        input | expected
        ""             | [""]
        "123"          | ["123"]
        "aa123"        | ["a", "a", "123"]
        "(124); (123)" | ["(", "124", ")", ";", " ", "(", "123", ")"]
        "a123;()45"    | ["a", "123", ";", "(", ")", "45"]
    }

}