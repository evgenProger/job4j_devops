package ru.job4j.devops.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;

import static org.assertj.core.api.Assertions.assertThat;

class CalcControllerTest {

    @Test
    public void whenOnePlusOneThenTwo() {
        var input = new TwoArgs(1, 1);
        var expected = new Result(2);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenZeroPlusZero() {
        var input = new TwoArgs(0, 3);
        var expected = new Result(3);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenTwoTimesTwoThenFour() {
        var input = new TwoArgs(2, 2);
        var expected = new Result(4);
        var output = new CalcController().times(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenZeroTimesZero() {
        var input = new TwoArgs(0, 0);
        var expected = new Result(0);
        var output = new CalcController().times(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenTimesNegatives() {
        var input = new TwoArgs(-3, -3);
        var expected = new Result(9);
        var output = new CalcController().times(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenNegativeNumber() {
        var input = new TwoArgs(-1, -1);
        var expected = new Result(-2);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenThreePlusFiveThenEight() {
        var input = new TwoArgs(3, 5);
        var expected = new Result(8);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenLargeNumbersSummedThenCorrectResult() {
        var input = new TwoArgs(1_000_000, 2_000_000);
        var expected = new Result(3_000_000);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenFivePlusSevenThenTwelve() {
        var input = new TwoArgs(5, 7);
        var expected = new Result(12);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenZeroTimesFiveThenZero() {
        var input = new TwoArgs(0, 5);
        var expected = new Result(0);
        var output = new CalcController().times(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenSixPlusSevenThenThree() {
        var input = new TwoArgs(6, 7);
        var expected = new Result(13);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }

    @Test
    public void whenTwoPlusTwoThenFour() {
        var input = new TwoArgs(2, 2);
        var expected = new Result(4);
        var output = new CalcController().summarise(input);
        assertThat(output.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(output.getBody()).isEqualTo(expected);
    }
}