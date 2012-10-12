package com.vinci.second;

import com.vinci.Num;

public class GuessCenter {
    private NumGenerator numGenerator;
    private Num expected;

    public GuessCenter(NumGenerator numGenerator) {
        this.numGenerator = numGenerator;
    }

    public void generateNum() {
        this.expected = this.numGenerator.generate();
    }

    public Num guess(Num guessNum) {
        return guessNum.against(expected);
    }

    public Num guess(String guessString) {
        return Num.createNum(guessString).against(expected);
    }
}
