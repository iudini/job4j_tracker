package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("id " + item.getId() + " - " + item.getName());
        } else {
            System.out.println("The object with this id was not found");
        }
        return true;
    }
}
