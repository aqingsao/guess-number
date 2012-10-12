package com.vinci.first;

import com.vinci.Num;

public class GuessCenter {
    private Num expected;

    public GuessCenter() {
    }

    public void generateNum() {
        this.expected = generateRandomNum();
        System.out.println("The mythical number is " + expected);
    }

    private Num generateRandomNum() {
        StringBuffer sb = new StringBuffer();
        while (sb.length() < 4) {
            int num = (int) (Math.random() * 10);
            if (notDuplicate(sb, num)) {
                sb.append(num);
            }
        }
        return Num.createNum(sb.toString());
    }

    private boolean notDuplicate(StringBuffer sb, int num) {
        return !sb.toString().contains(num + "");
    }

    public Result guess(Num guessNum) {
        return guessNum.against(expected);
    }
}
