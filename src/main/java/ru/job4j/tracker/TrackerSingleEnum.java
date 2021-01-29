package ru.job4j.tracker;

public enum TrackerSingleEnum {
    INSTANCE;

    private final MemTracker tracker = new MemTracker();

    public MemTracker getTracker() {
        return tracker;
    }
}
