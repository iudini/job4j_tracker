package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {
    @Test
    public void whenSuccessfulReplaceAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit Item ====" + ln + "1 editing is complete" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenUnreachableReplaceAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit Item ====" + ln
                + "Editing not possible, object has not found" + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }

    @Test
    public void whenSuccessfulDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete Item ====" + ln + "Deleting is complete" + ln));
        assertThat(tracker.findAll(), is(new ArrayList<>()));
    }

    @Test
    public void whenUnreachableDeleteAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete Item ====" + ln
                + "Deleting not possible, object has not found" + ln));
    }

    @Test
    public void whenSuccessfulFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        FindItemByIdAction act = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        act.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item by Id ====" + ln + "id 1 - New item" + ln));
    }

    @Test
    public void whenUnreachableFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        FindItemByIdAction act = new FindItemByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(2);

        act.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item by Id ====" + ln
                + "The object with this id was not found" + ln));
    }

    @Test
    public void whenSuccessfulFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        FindItemsByNameAction act = new FindItemsByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        act.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln + "id 1 - New item" + ln));
    }

    @Test
    public void whenSuccessfulManyNamesFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        tracker.add(new Item("New item"));
        FindItemsByNameAction act = new FindItemsByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("New item");

        act.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "id 1 - New item" + ln
                + "id 2 - New item" + ln));
    }

    @Test
    public void whenUnreachableFindByNameAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("New item"));
        FindItemsByNameAction act = new FindItemsByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("any item");

        act.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "The object with this name was not found" + ln));
    }
}
