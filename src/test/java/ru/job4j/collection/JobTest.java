package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void jobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Beta", 1),
                new Job("Gamma", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expect = Arrays.asList(
                new Job("X-ray", 0),
                new Job("Gamma", 4),
                new Job("Beta", 1),
                new Job("Alfa", 2)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void jobIncByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Beta", 1),
                new Job("Gamma", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Collections.sort(jobs, new JobIncByName());
        List<Job> expect = Arrays.asList(
                new Job("Alfa", 2),
                new Job("Beta", 1),
                new Job("Gamma", 4),
                new Job("X-ray", 0)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void jobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Alfa", 1),
                new Job("Alfa", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expect = Arrays.asList(
                new Job("Alfa", 4),
                new Job("Alfa", 2),
                new Job("Alfa", 1),
                new Job("X-ray", 0)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void jobIncByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Alfa", 1),
                new Job("Alfa", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Collections.sort(jobs, new JobIncByPriority());
        List<Job> expect = Arrays.asList(
                new Job("X-ray", 0),
                new Job("Alfa", 1),
                new Job("Alfa", 2),
                new Job("Alfa", 4)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityInc() {
        List<Job> jobs = Arrays.asList(
                new Job("Alfa", 1),
                new Job("Alfa", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Comparator<Job> cmpNamePriorityInc = new JobIncByName().thenComparing(new JobIncByPriority());
        Collections.sort(jobs, cmpNamePriorityInc);
        List<Job> expect = Arrays.asList(
                new Job("Alfa", 1),
                new Job("Alfa", 2),
                new Job("Alfa", 4),
                new Job("X-ray", 0)
        );
        assertThat(jobs, is(expect));
    }
}