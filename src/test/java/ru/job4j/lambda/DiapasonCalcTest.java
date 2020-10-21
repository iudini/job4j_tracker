package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonCalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenParabolaResults() {
        List<Double> result = DiapasonCalc.diapason(0, 3, x -> 2 * x * x + 3 * x - 5);
        List<Double> expected = Arrays.asList(-5D, 0D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowFunctionThenLinearResults() {
        List<Double> result = DiapasonCalc.diapason(0, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}