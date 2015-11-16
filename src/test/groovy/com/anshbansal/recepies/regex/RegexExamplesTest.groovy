package com.anshbansal.recepies.regex

import spock.lang.Specification

class RegexExamplesTest extends Specification {

    def "test that insideDoubleSquareBrackets returns all Strings"() {

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

}