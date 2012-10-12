package com.vinci.third;

import com.vinci.Num;

public class RandomNumGenerator implements NumGenerator {
    public Num generate() {
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
        return sb.toString().indexOf(num + "") < 0;
    }
}
