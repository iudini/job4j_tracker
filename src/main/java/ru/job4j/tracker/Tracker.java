package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item task) {
        task.setId(ids++);
        items[size++] = task;
        return task;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item task = items[index];
            if (task.getId() == id) {
                rsl = task;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String name) {
        Item[] namesFound = new Item[size];
        int index = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                namesFound[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(namesFound, index);
    }

    public Item[] findAll() {
        Item[] itemsWithoutNulls = new Item[size];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNulls[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(itemsWithoutNulls, index);
    }
}