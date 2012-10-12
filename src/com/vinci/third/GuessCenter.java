package com.vinci.third;

import com.vinci.Num;

public class GuessCenter {
    private NumGenerator numGenerator;
    private Num expected;

    public GuessCenter(NumGenerator numGenerator) {
        this.numGenerator = numGenerator;
    }

    public void generateNum() {
        this.expected = this.numGenerator.generate();
        System.out.println("Mythical number is: " + this.expected);
    }

    public Results guess(String guessString) {
        return Num.createNum(guessString).against(expected);
    }
}
