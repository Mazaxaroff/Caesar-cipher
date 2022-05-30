package ru.javarush.maxzaharov.ceasarcipher;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Keys {

    public static int getKey(boolean isRandom) {
        int key;
        if (isRandom) {
            key = keyRandom();
        } else {
            do {
                key = keyFrom();
            } while (key == 0 || Math.abs(key) > Alfabet.sizeOfAlfabet());
        }
        return key;
    }

    public static int keyFrom() {
        Scanner scanner = new Scanner(System.in);
        int from = 0;
        try {
            from = scanner.nextInt();
            if (Math.abs(from) > Alfabet.sizeOfAlfabet()) {
                Dialog.wrongKey(from);
            }
        } catch (InputMismatchException e) {
            Dialog.notInt(from);
        }
        return from;
    }

    public static int keyRandom() {
        int keyRandom;
        Random random = new Random();
        keyRandom = random.nextInt(Alfabet.sizeOfAlfabet());
        return keyRandom;
    }
}
