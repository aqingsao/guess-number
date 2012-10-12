package com.vinci.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleNumIO implements NumIO {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeOutput(String line) {
        System.out.println(line);
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
        }
    }
}