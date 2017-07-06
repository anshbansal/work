package com.anshbansal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {

    public static int getInt(Scanner sc) {
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }

    public static List<Integer> getIntegers(Scanner sc, int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(sc.nextInt());
        }
        return result;
    }

    public static List<String> getStrings(Scanner sc, int n) {

        List<String> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(sc.nextLine());
        }
        return result;
    }
}
