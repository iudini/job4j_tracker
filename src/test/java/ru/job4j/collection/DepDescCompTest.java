package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class DepDescCompTest {

    @Test
    public void sortDesc() {
        List<String> orgs = new ArrayList<>(List.of("K1", "K1/SK2", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K2", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2/SK1"));
        new Departments().sortDesc(orgs);
        List<String> rsl = List.of("K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2");
        assertThat(orgs, is(rsl));
    }

    @Test
    public void sortAsc() {
        List<String> orgs = new ArrayList<>(List.of("K1", "K1/SK2", "K2/SK1/SSK1", "K2/SK1/SSK2",
                "K2", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2/SK1"));
        new Departments().sortAsc(orgs);
        List<String> rsl = List.of("K1", "K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2",
                "K2", "K2/SK1", "K2/SK1/SSK1", "K2/SK1/SSK2");
        assertThat(orgs, is(rsl));
    }

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K1/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

}