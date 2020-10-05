package ru.job4j.tracker;

public class TrackerSingleLazyInnerClass {
    private TrackerSingleLazyInnerClass() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }
}
