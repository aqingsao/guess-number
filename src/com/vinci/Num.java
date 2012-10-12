package com.vinci;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num {
    private char[] chars;
//    public static final Num CORRECT = createNum("4A0B");

    private Num(char... chars) {
        this.chars = chars;
    }

    public static Num createNum(String num) {
        return new Num(num.toCharArray());
    }

    public boolean isCorrect() {
        return this.equals("4A0B");
    }

    public Results against(Num expected) {
        Results results = new Results();
        for (int i = 0; i < this.chars.length; i++) {
            results.add(getHint(expected.chars, i, this.chars[i]));
        }
        return results;
    }

    private Result getHint(char[] chars, int index, char c) {
        if (chars[index] == c) {
            return Result.A;
        } else if (contains(chars, c)) {
            return Result.B;
        }
        return Result.O;
    }

    private boolean contains(char[] chars, char ch) {
        for (char c : chars) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (char num : chars) {
            sb.append(num);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return Arrays.equals(chars, ((Num) o).chars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(chars);
    }

    private enum Result {
        A, B, O;
    }

    class Results {
        private List<Result> results = new ArrayList<Result>();

        public void add(Result result) {
            this.results.add(result);
        }
    }
}
