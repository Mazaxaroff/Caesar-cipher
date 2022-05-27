package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main {
    private static int key;
    private static final int sizeOfAlfabet = alfabet().size();
    private static final List<Character> ALFABET = alfabet();
    private static final String EXIT = "Для выхода из программы введите exit";
    private static final String GOODBAY ="Всего доброго!";

    public static void main(String[] args) {
        dialog();
    }

    public static void dialog() {
        System.out.println("Добро пожаловать в мир шифрования!\n" +
                "Вы хотите зашифровать текст? Введите y или n\n" + EXIT);
        if (question()) {
            doYouHaveKey();
            if (question()) {
                enterKey();
                do {
                    key = keyFrom();
                } while (key == 0 || Math.abs(key) > sizeOfAlfabet);
                writeToFile(cipherList(), pathOfFileOut());
                System.out.println(GOODBAY);


            } else {
                System.out.println("Ключ будет сгенерирован случайным образом из диапазона возможных");
                key = keyRandom();

            }
        } else {
            System.out.println("Вы хотите расшифровать текст? Введите y или n\n" + EXIT);
            if (question()) {
                doYouHaveKey();
                if (question()) {
                    enterKey();
                    do {
                        key = keyFrom();
                    } while (key == 0 || Math.abs(key) > sizeOfAlfabet);
                   writeToFile(decipherList(), pathOfFileOut());
                    System.out.println(GOODBAY);

                } else { //brutForse

                }
            } else {
                System.out.println(GOODBAY);
                System.exit(1);
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
                System.out.println("Всего доброго!");
                System.exit(2);
                break;
            } else {
                System.out.println("Ответ " + answer + " не корректный, введите y или n");
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
                System.out.println("Число " + keyFrom + " выходит из диапазона ключей! Попробуйте еще раз!\n" + EXIT);
            }
        } catch (InputMismatchException e) {
            System.err.println(keyFrom + "- не целое число! Попробуйте еще раз!\n" + EXIT);
        }
        return keyFrom;
    }

    public static int keyRandom() {
        int keyRandom;
        Random random = new Random();
        keyRandom = random.nextInt(sizeOfAlfabet);
        return keyRandom;
    }

    public static Path pathOfFileIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите полный путь к файлу с кодировкой UTF8," +
                " из которого требуется обработать текст на русском языке\n" + EXIT);
        String path;
        do {
            path = scanner.nextLine();
            try {
                Path pathOfFile = Path.of(path);
                if (!Files.exists(pathOfFile)) {
                    System.out.println("Файла с путем " + pathOfFile + " не существует, попробуйте еще раз!\n" + EXIT);
                } else if (!Files.isRegularFile(pathOfFile)) {
                    System.out.println(pathOfFile + " является директорией, введите полный путь к файлу!\n" + EXIT);
                }
            } catch (InvalidPathException e) {
                System.err.println("Путь не может быть сконвертирован");
            }
        } while (!Files.exists(Path.of(path)));
        return Path.of(path);
    }

    public static Path pathOfFileOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите полный путь к файлу в который требуется записать зашифрованный текст\n"
                + EXIT);
        String path;
        do {
            path = scanner.nextLine();
            try {
                Path pathOfFile = Path.of(path);
                if (!Files.exists(pathOfFile)) {
                    System.out.println("Файла с путем " + pathOfFile + " не существует, попробуйте еще раз!\n" + EXIT);
                } else if (!Files.isRegularFile(pathOfFile)) {
                    System.out.println(pathOfFile + " является директорией, введите полный путь к файлу!\n" + EXIT);
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
                System.err.println("Произошла ошибка чтения файла! " + e.getMessage());
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
                char newChar = ALFABET.get((ALFABET.indexOf(ch) + (sizeOfAlfabet - shift)) % sizeOfAlfabet);
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> cipherList() {
        List<String> cipherList = new ArrayList<>();
        for (String stringOfText : listFromFile(pathOfFileIn())) {
            cipherList.add(cihper(stringOfText, key));
        }
        return cipherList;
    }

    public static List<String> decipherList() {
        List<String> decipherList = new ArrayList<>();
        for (String stringOfText : listFromFile(pathOfFileIn())) {
            decipherList.add(decihper(stringOfText, key));
        }
        return decipherList;
    }

    public static void writeToFile(List<String> list, Path path) {
        try {
            Files.write(path, list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Произошла ошибка вывода!" + e.getMessage());
            ;
        } catch (IllegalArgumentException e) {
            System.err.println("Произошла ошибка исходных данных!" + e.getMessage());
        }
    }
}


