package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Item ====");
        Item[] result = tracker.findAll();
        for (Item item : result) {
            out.println("id " + item.getId() + " - " + item.getName());
        }
        return true;
    }
}
