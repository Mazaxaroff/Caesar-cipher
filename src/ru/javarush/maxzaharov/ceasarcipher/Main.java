package ru.javarush.maxzaharov.ceasarcipher;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int key;

    public static void main(String[] args) {
        dialog();
    }

    public static void dialog() {
        System.out.println("Добро пожаловать в мир шифрования!\n" +
                "Вы хотите зашифровать текст? Введите y или n");
        if (question()) {
            doYouHaveKey();
            if (question()) {
                enterKey();
                do {
                    key = keyFrom();
                } while (key == 0);
                System.out.println(key + " - Это ваш ключ");

            } else {
                System.out.println("Ключ будет сгенерирован случайным образом");
                key = keyRandom();
                System.out.println("Случайный ключ - " + key);
            }
        } else {
            System.out.println("Вы хотите расшифровать текст? Введите y или n");
            if (question()) {
                doYouHaveKey();
                if (question()) {
                    enterKey();
                    do {
                        key = keyFrom();
                    } while (key == 0);
                        System.out.println(key + " - Это ваш ключ");
                }
            } else {
                System.out.println("Всего доброго!");
                System.exit(1);
            }

        }
    }

    public static boolean question() {
        Scanner scanner = new Scanner(System.in);
        boolean yesOrNot;
        String answer;
        while (true) {
            answer = scanner.nextLine();
            if ("y".equals(answer.toLowerCase())) {
                yesOrNot = true;
                break;
            }
            if ("n".equals(answer.toLowerCase())) {
                yesOrNot = false;
                break;
            } else {
                System.out.println("Ответ не корректный, введите y или n");
            }
        }
        return yesOrNot;
    }

    public static void doYouHaveKey() {
        System.out.println("У вас есть ключ шифрования?");
    }

    public static void enterKey() {
        System.out.println("Пожалуйста введите целое число от 1 до 32");
    }

    public static int keyFrom() {
        Scanner scanner = new Scanner(System.in);
        int keyFrom = 0;
        try {
            keyFrom = scanner.nextInt();
            if (keyFrom == 0) {
                System.out.println("Вы ввели ноль! Попробуйте еще раз!");
            }
        } catch (RuntimeException e) {
            System.err.println("Введено не целое число! Попробуйте еще раз!");
        }
        return keyFrom;
    }

    public static int keyRandom() {
        int keyRandom;
        Random random = new Random();
        keyRandom = random.nextInt(33);
        return keyRandom;
    }
}
