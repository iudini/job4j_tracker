package ru.job4j.tracker;

public class TrackerSingleEager {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingleEager() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }
}
