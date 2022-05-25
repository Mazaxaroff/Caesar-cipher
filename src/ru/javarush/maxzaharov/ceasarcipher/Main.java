package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.*;

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
                for (String s : listFromFile(absolutePathOfFile())) {
                    System.out.println(s);
                }


            } else {
                System.out.println("Ключ будет сгенерирован случайным образом");
                key = keyRandom();

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

                } else { //brutForse

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
        } catch (InputMismatchException e) {
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

    public static Path absolutePathOfFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста укажите путь к файлу, из которого требуется обработать текст");
        String pathOfFile;
        do {
            pathOfFile = scanner.nextLine();
            try {
                Path absolutePath = Path.of(pathOfFile).toAbsolutePath().normalize();
                if (!Files.exists(absolutePath)) {
                    System.out.println("Такого файла не существует, попробуйте еще раз!");
                }
                System.out.println(absolutePath);
                System.out.println(Files.exists(absolutePath));
            } catch (InvalidPathException e) {
                System.err.println("Путь не может быть сконвертирован");
                
            } catch (SecurityException e) {
                System.err.println("Ошибка безопасности");
            }
        } while (!Files.exists(Path.of(pathOfFile).toAbsolutePath().normalize()));
        Path absolutePathOfFile = Path.of(pathOfFile).toAbsolutePath().normalize();
        return absolutePathOfFile;
    }

    public static List<String> listFromFile(Path path) {
        List<String> listFromFile = new ArrayList<>();
        if (Files.isReadable(path)) {
            try {
                listFromFile = Files.readAllLines(path);
            } catch (IOException e) {
                System.out.println("Произошла ошибка чтения файла");
            }
        } else {
            System.out.println("Невозможно прочитать файл");
        }
        return listFromFile;
    }


}
