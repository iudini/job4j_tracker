package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("id " + item.getId() + " - " + item.getName());
        } else {
            out.println("The object with this id was not found");
        }
        return true;
    }
}
