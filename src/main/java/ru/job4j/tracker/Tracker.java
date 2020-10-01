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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index].setName(item.getName());
        return true;
    }
}