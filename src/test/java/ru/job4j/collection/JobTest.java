package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
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
        jobs.sort(new JobDescByName());
        List<Job> expect = List.of(
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
        jobs.sort(new JobIncByName());
        List<Job> expect = List.of(
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
        jobs.sort(new JobDescByPrior());
        List<Job> expect = List.of(
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
        jobs.sort(new JobIncByPrior());
        List<Job> expect = List.of(
                new Job("X-ray", 0),
                new Job("Alfa", 1),
                new Job("Alfa", 2),
                new Job("Alfa", 4)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePrior = new JobDescByName().thenComparing(new JobDescByPrior());
        int rsl = cmpNamePrior.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPriorityInc() {
        List<Job> jobs = Arrays.asList(
                new Job("Alfa", 1),
                new Job("Alfa", 4),
                new Job("Alfa", 2),
                new Job("X-ray", 0)
        );
        Comparator<Job> cmpNamePriorInc = new JobIncByName().thenComparing(new JobIncByPrior());
        jobs.sort(cmpNamePriorInc);
        List<Job> expect = List.of(
                new Job("Alfa", 1),
                new Job("Alfa", 2),
                new Job("Alfa", 4),
                new Job("X-ray", 0)
        );
        assertThat(jobs, is(expect));
    }
}