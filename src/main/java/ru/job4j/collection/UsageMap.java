package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("grigor@mail.ru", "Grigoriy Petrov");
        map.put("keklolazaza@gmail.com", "Bill Jobs");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println();
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        map.remove("keklolazaza@gmail.com");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
