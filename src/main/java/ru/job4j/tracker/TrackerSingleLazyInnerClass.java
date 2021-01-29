package ru.job4j.tracker;

public class TrackerSingleLazyInnerClass {
    private TrackerSingleLazyInnerClass() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }
}
