package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item(1, "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "bug");
            tracker.add(item);
            item.setName("bug fixed");
            tracker.replace(item.getId(), item);
            assertThat("bug fixed", is(tracker.findById(item.getId()).getName()));
        }
    }

    @Test
    public void whenDelete() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "bug");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findById(item.getId()), is(nullValue()));
        }
    }

    @Test
    public void whenFoundByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item(1, "Bug");
            tracker.add(item);
            assertThat(tracker.findByName("Bug").get(0).getName(), is("Bug"));
        }
    }

    @Test
    public void whenFoundAll() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Bug"));
            tracker.add(new Item("cat"));
            tracker.add(new Item("bat"));
            List<String> rsl = new ArrayList<>();
            tracker.findAll().forEach(i -> rsl.add(i.getName()));
            assertThat(rsl, is(List.of("Bug", "cat", "bat")));
        }
    }
}