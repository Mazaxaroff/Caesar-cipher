package ru.javarush.maxzaharov.ceasarcipher;

import java.util.Scanner;

public class Dialog {

    private static final String EXIT = "Для выхода из программы введите exit";
    private static final String GOODBAY = "Операция успешно завершена! Всего доброго!";
    private static final String YES_OR_NO = "Введите y или n\n";
    private static final String PATH_IN = "Пожалуйста введите полный путь к файлу с кодировкой UTF8," +
            " из которого требуется обработать текст на русском языке\n";
    private static final String PATH_OUT = "Пожалуйста введите полный путь к файлу в который требуется записать " +
            "измененный текст\n";

    public static void dialog() {
        System.out.println("Добро пожаловать в мир шифрования!\n" +
                "Вы хотите зашифровать текст?\n" + YES_OR_NO + EXIT);
        if (question()) {
            doYouHaveKey();
            if (question()) {
                enterKey();
                Converter.cipherWithKey();
            } else {
                System.out.println("Ключ будет сгенерирован случайным образом из диапазона возможных");
                Converter.cipherWithoutKey();
            }
        } else {
            System.out.println("Вы хотите расшифровать текст? \n" + YES_OR_NO + EXIT);
            if (question()) {
                doYouHaveKey();
                if (question()) {
                    enterKey();
                   Converter.decipherWithKey();

                } else {
                    Converter.bruteForce();
                }
            } else {
                goodbay();
            }

        }
    }

    public static boolean question() {
        Scanner scanner = new Scanner(System.in);
        boolean yesOrNot = false;
        String answer;
        while (true) {
            answer = scanner.nextLine();
            if ("y".equals(answer.toLowerCase())) {
                yesOrNot = true;
                break;
            } else if ("n".equals(answer.toLowerCase())) {
                yesOrNot = false;
                break;
            } else if ("exit".equals(answer.toLowerCase())) {
                System.out.println(GOODBAY);
                System.exit(2);
                break;
            } else {
                System.out.println("Ответ " + answer + " не корректный!\n" + YES_OR_NO);
            }
        }
        return yesOrNot;
    }

    public static void doYouHaveKey() {
        System.out.println("У вас есть ключ шифрования?\n" + YES_OR_NO + EXIT);
    }

    public static void enterKey() {
        System.out.println("Пожалуйста введите целое число от 1 до " + Alfabet.sizeOfAlfabet());
    }

    public static void pathIn() {
        System.out.println(PATH_IN + EXIT);
    }

    public static void pathOut() {
        System.out.println(PATH_OUT + EXIT);
    }

    public static void goodbay() {
        System.out.println(GOODBAY);
    }

    public static String exit() {
        return EXIT;
    }

}


