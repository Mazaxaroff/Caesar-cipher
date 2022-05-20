package ru.javarush.maxzaharov.ceasarcipher;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //приветствие


        String whatYouWant = "Привет! Добро пожаловать в мир шифрования!\n" +
                "Если Вы хотите зашифровать текст - нажмите 1 \n" +
                "Если вы хотите расшифровать текст - нажмите 2";

        System.out.println(whatYouWant);

        String answer = "0";
        while (!answer.equals("1") || !answer.equals("2")) {
            answer = scanner.nextLine();
            if (answer.equals("1") || answer.equals("2")) {
                doYouHaveKey();
                break;
            } else {
                System.out.println("Введен некорректный номер, введите 1 или 2");
            }
        }


        //дописать метод
    }

    public static int doYouHaveKey() {
        Scanner scanner = new Scanner(System.in);
        String haveKey = "У вас есть ключ? \n" +
                "Если есть - нажмите 1 \n" +
                "Если нет - нажмите 2";
        System.out.println(haveKey);
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
    }


}
