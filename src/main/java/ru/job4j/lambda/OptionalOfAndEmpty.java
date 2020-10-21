package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optional = Optional.of(value);
        for (String string : strings) {
            if (Optional.of(string).equals(optional)) {
                return optional;
            }
        }
        return Optional.empty();
    }
}
