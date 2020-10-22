package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(List.of(-10, 7, 2, 3, 5, 13, 6));
        List<Integer> list = array.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
    }
}
