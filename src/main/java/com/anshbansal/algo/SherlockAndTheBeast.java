package com.anshbansal.algo;

import com.anshbansal.util.InputUtil;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class SherlockAndTheBeast {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {

            int length = sc.nextInt();

            List<String> strings = myPermutations(length);
            if (strings.size() == 0) {
                println("-1");
            } else {
                for (String str : myPermutations(length)) {
                    println(str);
                }
            }
        }
    }

    private static List<String> lengths(int maxLength, int combinationsLength, char c) {
        List<String> result = new ArrayList<>();
        result.add("");

        String combination = "";
        for (int i = 0; i < combinationsLength; i++) {
            combination += c;
        }

        String builder = "";
        for (int i = 0; i < maxLength; i += combinationsLength) {
            builder = builder + combination;
            result.add(builder);
        }

        return result;
    }

    private static List<String> myPermutations(int length) {

        List<String> fives = lengths(length, 3, '5');

        List<String> threes = lengths(length, 5, '3');

        List<String> results = new ArrayList<>();
        for (String five : fives) {
            for (String three : threes) {
                String tmp = five + three;
                if (tmp.length() == length) {
                    results.add(tmp);
                }
            }
        }
        return results;
    }

    public static boolean lengthOfStringDivisibleBy(String str, Pattern occurrencesOf, int divisibleBy) {

        String onlyOccurrencesOf = occurrencesOf.matcher(str).replaceAll("");

        return onlyOccurrencesOf.length() % divisibleBy == 0;
    }

    public static BigInteger max(List<BigInteger> bigIntegers) {

        if (bigIntegers.size() == 0) {
            return BigInteger.ONE.negate();
        }
        BigInteger result = bigIntegers.get(0);
        for (BigInteger bigInteger : bigIntegers) {
            result = result.max(bigInteger);
        }
        return result;
    }



    public static Set<String> allPermutations(int length, char... chars) {

        Set<String> result = new HashSet<>();
        addPermutations(result, length, "", chars);
        return result;
    }

    private static void addPermutations(Set<String> result, int length,
                                        String prefix, char... chars) {

        if (length == 0) {
            result.add(prefix);
            return;
        }
        for (char aChar : chars) {
            addPermutations(result, length - 1, prefix + aChar, chars);
        }
    }


    public static void println(String str) {

        System.out.println(str);
    }


    static void testCases() {

        Scanner sc = new Scanner(System.in);
        int testCases = InputUtil.getInt(sc);

        for (int testCase = 0; testCase < testCases; testCase++) {

        }
    }

}
