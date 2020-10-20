package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> left = List.of(o1.split("/"));
        List<String> right = List.of(o2.split("/"));
        int rsl = right.get(0).compareTo(left.get(0));
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
