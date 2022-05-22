package ru.javarush.maxzaharov.ceasarcipher;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        dialog();


    }

    /*public static int key() {

        int key = 0;
        String answer = "0";
        while (!answer.equals("1") || !answer.equals("2")) {
            answer = scanner.nextLine();
            if (answer.equals("1")) {
                System.out.println("Введите ключ от 1 до 32");
                try {
                    key = scanner.nextInt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            } else if (answer.equals("2")) {
                System.out.println("Ключ будет сгенерирован случайным образом");
                Random random = new Random();
                key = random.nextInt(33);
                break;
            } else {
                System.out.println("Введен некорректный номер, введите 1 или 2");
            }
        }

        return key;
    }*/

    public static void dialog() {
        System.out.println("Привет! Добро пожаловать в мир шифрования!\n" +
                "Вы хотите зашифровать текст? Введите y или n");
        if (question()) {
            doYouHaveKey();
            System.out.println("ок");
        } else {
            System.out.println("Вы хотите расшифровать текст? Введите y или n");
            if (question()) {
                doYouHaveKey();
                if (question())
                    enterKey();
                System.out.println(keyFrom() + " - Это ваш ключ");
                System.out.println("тоже ок");
            } else {
                System.out.println("Всего доброго!");
                System.exit(1);
            }

        }
    }

    public static boolean question() {
        Scanner scanner = new Scanner(System.in);
        boolean yesOrNot = false;
        String answer = "0";
        while (true) {
            answer = scanner.nextLine();
            if ((answer.toLowerCase()).equals("y")) {
                yesOrNot = true;
                break;
            }
            if ((answer.toLowerCase()).equals("n")) {
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
        int key = 0;
        while (key == 0) {
            try {
                key = scanner.nextInt();
                break;
            } catch (RuntimeException e) {
                System.err.println("Введено не целое число! Попробуйте еще раз");
            }
        }
        return key;
    }
}
