package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void testConvert() {
        MatrixToList matrixToList = new MatrixToList();
        Integer[][] list = new Integer[][]{
            new Integer[]{1, 2, 3},
            new Integer[]{4, 5, 6}
        };
        List<Integer> rsl = matrixToList.convert(list);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}