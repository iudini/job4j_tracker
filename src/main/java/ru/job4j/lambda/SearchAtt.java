package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(predicate, list);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(predicate, list);
    }

    private static List<Attachment> filter(Predicate<Attachment> predicate, List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment item : list) {
            if (predicate.test(item)) {
                rsl.add(item);
            }
        }
        return rsl;
    }
}