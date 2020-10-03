package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] result = tracker.findAll();
        for (Item item : result) {
            System.out.println("id " + item.getId() + " - " + item.getName());
        }
        return true;
    }
}
