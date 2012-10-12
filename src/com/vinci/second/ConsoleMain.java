package com.vinci.second;

import com.vinci.Num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMain {

    private GuessCenter guessCenter;

    public ConsoleMain() {
        guessCenter = new GuessCenter(new RandomNumGenerator());
    }

    public static void main(String[] args) {
        ConsoleMain consoleMain = new ConsoleMain();
        consoleMain.startToPlay();

        System.out.println("Game started, please input a 4-digit number...");
        consoleMain.guessUntilWin();
        System.out.println("Game is over.");
    }

    private void startToPlay() {
        guessCenter.generateNum();
    }

    private void guessUntilWin() {
        System.out.println("Game started, please input a 4-digit number...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Num result = guessCenter.guess(Num.createNum(reader.readLine()));
            while (!result.isCorrect()) {
                System.out.println(result);
                result = guessCenter.guess(Num.createNum(reader.readLine()));
            }
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(reader);
        }

        System.out.println("Game is over.");
    }

    private void closeQuietly(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
        }
    }
}
