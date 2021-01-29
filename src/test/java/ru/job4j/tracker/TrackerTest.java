package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
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
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenFoundByName() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        assertThat(tracker.findByName("Bug").get(0).getName(), is("Bug"));
    }

    @Test
    public void whenFoundAll() {
        MemTracker tracker = new MemTracker();
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
        List<Item> resultItem = tracker.findAll();
        List<String> rsl = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("Bug");
        expected.add("cat");
        expected.add("bat");
        for (Item item : resultItem) {
            rsl.add(item.getName());
        }
        assertThat(rsl, is(expected));
    }

    @Test
    public void trackerSingleLazy() {
        MemTracker one = TrackerSingleLazy.getInstance();
        MemTracker two = TrackerSingleLazy.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void trackerSingleLazyInnerClass() {
        MemTracker one = TrackerSingleLazyInnerClass.getInstance();
        MemTracker two = TrackerSingleLazyInnerClass.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void trackerSingleEager() {
        MemTracker one = TrackerSingleEager.getInstance();
        MemTracker two = TrackerSingleEager.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void trackerSingleEnum() {
        MemTracker one = TrackerSingleEnum.INSTANCE.getTracker();
        MemTracker two = TrackerSingleEnum.INSTANCE.getTracker();
        assertThat(one, is(two));
    }
}