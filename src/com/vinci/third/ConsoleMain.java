package com.vinci.third;

import com.vinci.Num;

public class ConsoleMain {

    private GuessCenter guessCenter;
    private NumIO numIO;

    public ConsoleMain(NumIO numIO, GuessCenter guessCenter) {
        this.numIO = numIO;
        this.guessCenter = guessCenter;
        guessCenter.generateNum();
    }

    public static void main(String[] args) {
        ConsoleMain consoleMain = new ConsoleMain(new ConsoleNumIO(), new GuessCenter(new RandomNumGenerator()));
        consoleMain.startToPlay();

        System.out.println("Game started, please input a 4-digit number...");
        consoleMain.guessUntilWin();
        System.out.println("Game is over.");
    }

    private void startToPlay() {
        guessCenter.generateNum();
    }

    void guessUntilWin() {
        System.out.println("Game started, please input a 4-digit number...");

        try {
            Num result = guessCenter.guess(numIO.readInput());
            while (!result.isCorrect()) {
                numIO.writeOutput(result.toString());
                result = guessCenter.guess(numIO.readInput());
            }
            numIO.writeOutput(result.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            numIO.close();
        }

        System.out.println("Game is over.");
    }
}
