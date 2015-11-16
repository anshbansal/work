package com.anshbansal.recepies.regex

import spock.lang.Specification

class BadRegexExamplesTest extends Specification {

    def "test that number greater than 75 regex works"() {

    expect:
        BadRegexExamples.greaterThan75(input) == expected

    where:
        input | expected
        "-5"   | false
        "0"    | false
        "74"   | false
        "75"   | false
        "76"   | true
        "1000" | true
    }

}