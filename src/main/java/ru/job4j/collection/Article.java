package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String symbols = ",.!;:";
        for (char c : symbols.toCharArray()) {
            origin = origin.replace(c, ' ');
            line = line.replace(c, ' ');
        }
        Set<String> originSet = new HashSet<>(List.of(origin.split(" ")));
        Set<String> lineSet = new HashSet<>(List.of(line.split(" ")));
        lineSet.removeAll(originSet);
        return lineSet.isEmpty();
    }
}
