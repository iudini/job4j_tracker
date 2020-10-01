package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item created = new Item(0, "start");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTime = created.getCreated().format(formatter);
        System.out.println(currentDateTime);
        System.out.println(created);
    }
}
