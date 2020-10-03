package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println("id " + item.getId() + " - " + item.getName());
            }
        } else {
            System.out.println("The object with this name was not found");
        }
        return true;
    }
}
