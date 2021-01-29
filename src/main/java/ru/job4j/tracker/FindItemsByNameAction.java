package ru.job4j.tracker;

import java.util.List;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (!(items.isEmpty())) {
            for (Item item : items) {
                out.println("id " + item.getId() + " - " + item.getName());
            }
        } else {
            out.println("The object with this name was not found");
        }
        return true;
    }
}
