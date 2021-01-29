package ru.job4j.tracker;

public class TrackerSingleLazy {
    private static MemTracker instance;

    private TrackerSingleLazy() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
