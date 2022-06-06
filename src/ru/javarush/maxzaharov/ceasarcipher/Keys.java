package ru.javarush.maxzaharov.ceasarcipher;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Keys {

    public static int get(boolean keyIsRandom) {
        int key;
        if (keyIsRandom) {
            key = random();
        } else {
            do {
                key = input();
            } while (key == 0 || Math.abs(key) > Alfabet.size());
        }
        return key;
    }

    public static int input() {
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        try {
            key = scanner.nextInt();
            if (Math.abs(key) > Alfabet.size()) {
                Dialog.wrongKey(key);
            }
        } catch (InputMismatchException e) {
            Dialog.notInt(key);
        }
        return key;
    }

    public static int random() {
        Random random = new Random();
        return random.nextInt(Alfabet.size());
    }
}
