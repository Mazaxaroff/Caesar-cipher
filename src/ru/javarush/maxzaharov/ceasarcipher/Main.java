package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private static int key;
    private static final int sizeOfAlfabet = alfabet().size();
    private static final List<Character> ALFABET = alfabet();

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
                } while (key == 0 || Math.abs(key) > sizeOfAlfabet);
                for (String s : listFromFile(pathOfFile())) {
                    System.out.println(cihper(s, key));
                }


            } else {
                System.out.println("Ключ будет сгенерирован случайным образом из диапазона возможных");
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
                    } while (key == 0 || Math.abs(key) > sizeOfAlfabet);
                    for (String s : listFromFile(pathOfFile())) {
                        System.out.println(decihper(s, key));
                    }

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
        System.out.println("Пожалуйста введите целое число от 1 до " + sizeOfAlfabet);
    }

    public static int keyFrom() {
        Scanner scanner = new Scanner(System.in);
        int keyFrom = 0;
        try {
            keyFrom = scanner.nextInt();
            if (keyFrom == 0) {
                System.out.println("Вы ввели ноль! Попробуйте еще раз!");
            } else if (Math.abs(keyFrom) > sizeOfAlfabet) {
                System.out.println("Вы ввели число, выходящее из диапазона ключей! Попробуйте еще раз!");
            }
        } catch (InputMismatchException e) {
            System.err.println("Введено не целое число! Попробуйте еще раз!");
        }
        return keyFrom;
    }

    public static int keyRandom() {
        int keyRandom;
        Random random = new Random();
        keyRandom = random.nextInt(sizeOfAlfabet);
        return keyRandom;
    }

    public static Path pathOfFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите полный путь к файлу, из которого требуется обработать текст " +
                "на русском языке");
        String path;
        do {
            path = scanner.nextLine();
            try {
                Path pathOfFile = Path.of(path);
                if (!Files.exists(pathOfFile)) {
                    System.out.println("Такого файла не существует, попробуйте еще раз!");
                } else if (!Files.isRegularFile(pathOfFile)) {
                    System.out.println("Введена директория, введите полный путь к файлу! ");
                }
            } catch (InvalidPathException e) {
                System.err.println("Путь не может быть сконвертирован");
            }
        } while (!Files.exists(Path.of(path)));
        return Path.of(path);
    }

    public static List<String> listFromFile(Path path) {
        List<String> listFromFile = new ArrayList<>();
        if (Files.isReadable(path)) {
            try {
                listFromFile = Files.readAllLines(path);
            } catch (IOException e) {
                System.err.println("Произошла ошибка чтения файла");
            }
        } else {
            System.out.println("Невозможно прочитать файл");
        }
        return listFromFile;
    }

    public static List<Character> alfabet() {
        List<Character> alfabet = new ArrayList<>();
        for (char i = 'А'; i <= 'я'; i++) {
            alfabet.add(i);
        }
        alfabet.add('.');
        alfabet.add(',');
        alfabet.add('"');
        alfabet.add(':');
        alfabet.add(';');
        alfabet.add('-');
        alfabet.add('!');
        alfabet.add('?');
        alfabet.add(')');
        alfabet.add('(');
        alfabet.add(' ');
        return alfabet;
    }

    public static String cihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ALFABET.contains(ch)) {
                char newChar = ALFABET.get((ALFABET.indexOf(ch) + shift) % sizeOfAlfabet);
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static String decihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ALFABET.contains(ch)) {
                char newChar = ALFABET.get((ALFABET.indexOf(ch) +(sizeOfAlfabet-shift)) % sizeOfAlfabet);
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}


