package com.vinci.third;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.vinci.third.Num.createNum;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestGuessCenter {
    private NumGenerator numGenerator;
    private GuessCenter guessCenter;

    @Before
    public void before() {
        numGenerator = mock(NumGenerator.class);
        when(numGenerator.generate()).thenReturn(createNum("1234"));

        guessCenter = new GuessCenter(numGenerator);
    }

    @Test
    public void should_return_false_when_input_incorrect() throws IOException {
        guessCenter.generateNum();

        Num result = guessCenter.guess("5678");
        assertThat(result.isCorrect(), is(false));
    }

    @Test
    public void should_return_true_when_input_correct() throws IOException {
        guessCenter.generateNum();

        Num result = guessCenter.guess("1234");
        assertThat(result.isCorrect(), is(true));
    }

    @Test
    public void should_return_hint_A_when_digit_is_correct_and_position_is_correct() throws IOException {
        guessCenter.generateNum();

        assertThat(guessCenter.guess("1678"), is(createNum("A678")));
    }

    @Test
    public void should_return_hint_B_when_digit_is_correct_but_position_is_incorrect() throws IOException {
        guessCenter.generateNum();

        assertThat(guessCenter.guess("1378"), is(createNum("AB78")));

    }
}
