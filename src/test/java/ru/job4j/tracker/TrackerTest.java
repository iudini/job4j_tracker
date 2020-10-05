package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        assertThat(tracker.findByName("Bug")[0].getName(), is("Bug"));
    }

    @Test
    public void whenFoundAll() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        Item cat = new Item();
        Item dog = new Item();
        Item bat = new Item();
        bug.setName("Bug");
        cat.setName("cat");
        dog.setName("dog");
        bat.setName("bat");
        tracker.add(bug);
        tracker.add(cat);
        tracker.add(dog);
        tracker.add(bat);
        tracker.delete(3);
        Item[] resultItem = tracker.findAll();
        String[] rsl = new String[resultItem.length];
        String[] expected = new String[]{"Bug", "cat", "bat"};
        for (int i = 0; i < resultItem.length; i++) {
            rsl[i] = resultItem[i].getName();
        }
        assertThat(rsl, is(expected));
    }

    @Test
    public void TrackerSingleLazy() {
        Tracker one = TrackerSingleLazy.getInstance();
        Tracker two = TrackerSingleLazy.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void TrackerSingleLazyInnerClass() {
        Tracker one = TrackerSingleLazyInnerClass.getInstance();
        Tracker two = TrackerSingleLazyInnerClass.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void TrackerSingleEager() {
        Tracker one = TrackerSingleEager.getInstance();
        Tracker two = TrackerSingleEager.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void TrackerSingleEnum() {
        Tracker one = TrackerSingleEnum.INSTANCE.getTracker();
        Tracker two = TrackerSingleEnum.INSTANCE.getTracker();
        assertThat(one, is(two));
    }
}