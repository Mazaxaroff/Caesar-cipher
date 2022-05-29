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
        int keyFrom = 0;
        try {
            keyFrom = scanner.nextInt();
            if (keyFrom == 0) {
                System.out.println("Вы ввели ноль! Попробуйте еще раз!");
            } else if (Math.abs(keyFrom) > Alfabet.sizeOfAlfabet()) {
                System.out.println("Число " + keyFrom + " выходит из диапазона ключей! Попробуйте еще раз!");
            }
        } catch (InputMismatchException e) {
            System.err.println(keyFrom + "- не целое число! Попробуйте еще раз!");
        }
        return keyFrom;
    }

    public static int keyRandom() {
        int keyRandom;
        Random random = new Random();
        keyRandom = random.nextInt(Alfabet.sizeOfAlfabet());
        return keyRandom;
    }
}
