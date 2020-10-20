package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<String, Integer> result = new HashMap<>();
        List<String> leftList = List.of(left.split(""));
        for (String symbol : leftList) {
            result.putIfAbsent(symbol, 0);
            result.computeIfPresent(symbol, (key, value) -> value + 1);
        }
        List<String> rightList = List.of(right.split(""));
        for (String symbol : rightList) {
            if (!result.containsKey(symbol)) {
                return false;
            }
            result.computeIfPresent(symbol, (key, value) -> value - 1);
        }
        for (int value : result.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
