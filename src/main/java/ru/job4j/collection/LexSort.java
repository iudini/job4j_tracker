package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split(". ");
        int leftInt = Integer.parseInt(leftSplit[0]);
        String[] rightSplit = right.split(". ");
        int rightInt = Integer.parseInt(rightSplit[0]);
        return leftInt - rightInt;
    }
}
