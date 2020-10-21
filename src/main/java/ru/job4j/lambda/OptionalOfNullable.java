package ru.job4j.lambda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optValue = Optional.ofNullable(value);
        for (String string : strings) {
            if (Optional.ofNullable(string).equals(optValue)) {
                return optValue;
            }
        }
        return Optional.empty();
    }
}
