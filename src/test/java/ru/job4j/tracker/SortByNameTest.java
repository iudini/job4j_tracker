package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortByNameTest {

    @Test
    public void compareNameDecrease() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("bug"));
        list.add(new Item("cat"));
        list.add(new Item("dog"));
        list.add(new Item("bat"));
        Collections.sort(list, new SortByNameDecrease());
        List<String> rsl = new ArrayList<>();
        for (Item item : list) {
            rsl.add(item.getName());
        }
        List<String> expected = new ArrayList<>();
        expected.add("dog");
        expected.add("cat");
        expected.add("bug");
        expected.add("bat");
        assertThat(rsl, is(expected));
    }

    @Test
    public void compareNameIncrease() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("bug"));
        list.add(new Item("cat"));
        list.add(new Item("dog"));
        list.add(new Item("bat"));
        Collections.sort(list, new SortByNameIncrease());
        List<String> rsl = new ArrayList<>();
        for (Item item : list) {
            rsl.add(item.getName());
        }
        List<String> expected = new ArrayList<>();
        expected.add("bat");
        expected.add("bug");
        expected.add("cat");
        expected.add("dog");
        assertThat(rsl, is(expected));
    }
}