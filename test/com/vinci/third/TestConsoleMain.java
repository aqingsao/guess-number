package com.vinci.third;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestConsoleMain {

    private ConsoleMain consoleMain;
    private NumIO numIO;
    private NumGenerator numGenerator;
    private GuessCenter guessCenter;

    @Before
    public void setUp() throws Exception {
        numGenerator = mock(NumGenerator.class);
        when(numGenerator.generate()).thenReturn(Num.createNum("1234"));

        guessCenter = new GuessCenter(numGenerator);
    }

    @Test
    public void should_return_once_input_is_correct() {
        numIO = new FakeNumIO("1234", "5678");
        consoleMain = new ConsoleMain(numIO, guessCenter);

        consoleMain.guessUntilWin();

        List<String> outputList = ((FakeNumIO) numIO).getOutputList();
        assertThat(outputList.size(), is(1));
        assertThat(outputList.get(0), is("AAAA"));
    }

    @Test
    public void should_return_when_input_correct() {
        numIO = new FakeNumIO("5678", "1234");
        consoleMain = new ConsoleMain(numIO, guessCenter);

        consoleMain.guessUntilWin();

        List<String> outputList = ((FakeNumIO) numIO).getOutputList();
        assertThat(outputList.size(), is(2));
        assertThat(outputList.get(0), is("5678"));
        assertThat(outputList.get(1), is("AAAA"));
    }

    private class FakeNumIO implements NumIO {
        private List<String> inputList;
        private List<String> outputList;

        public FakeNumIO(String... inputList) {
            this.inputList = new ArrayList<String>();
            for (String s : inputList) {
                this.inputList.add(s);
            }

            this.outputList = new ArrayList<String>();
        }

        public String readInput() {
            return inputList.remove(0);
        }

        public void writeOutput(String line) {
            this.outputList.add(line);
        }

        public void close() {
        }

        public List<String> getOutputList() {
            return outputList;
        }
    }
}
