package ru.job4j.stream;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return Stream.of(it.next())
                .flatMap(x -> Stream.of(x.next()))
                .collect(Collectors.toList());
    }
}