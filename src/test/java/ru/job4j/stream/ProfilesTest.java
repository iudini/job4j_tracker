package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Msk", "Lenina", 5, 6)));
        profiles.add(new Profile(new Address("Msk", "Lenina", 5, 6)));
        profiles.add(new Profile(new Address("Nsk", "Marksa", 3, 7)));
        profiles.add(new Profile(new Address("Msk", "Lenina", 5, 6)));
        profiles.add(new Profile(new Address("Kzn", "Saharova", 1, 10)));
    }

    @Test
    public void collectTest() {
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Kzn", "Saharova", 1, 10));
        expected.add(new Address("Msk", "Lenina", 5, 6));
        expected.add(new Address("Nsk", "Marksa", 3, 7));
        assertThat(rsl, is(expected));
    }
}