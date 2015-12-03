package com.anshbansal.recepies.regex

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BadRegexExamplesTest extends Specification {

    def "test that #input > 75 is #expected"() {

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