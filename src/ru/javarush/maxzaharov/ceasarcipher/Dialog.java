package ru.javarush.maxzaharov.ceasarcipher;

import java.nio.file.Path;
import java.util.Scanner;

public class Dialog {

    private static final String EXIT = "Для выхода из программы введите exit";
    private static final String BAY = "Операция успешно завершена! Всего доброго!";
    private static final String YES_OR_NO = "Введите y или n\n";
    private static final String PATH_IN = "Пожалуйста введите полный путь к файлу с кодировкой UTF8," +
            " из которого требуется обработать текст на русском языке\n";
    private static final String PATH_OUT = "Пожалуйста введите полный путь к файлу в который требуется записать " +
            "измененный текст\n";

    public static void start() {
        hello();
        if (question()) {
            doYouHaveKey();
            if (question()) {
                enterKey();
                CipherChoice.encodingWithKey();
                bay();
            } else {
                randomKey();
                CipherChoice.encodingWithoutKey();
                bay();
            }
        } else {
            doYouNeedDecoding();
            if (question()) {
                doYouHaveKey();
                if (question()) {
                    enterKey();
                    CipherChoice.decodingWithKey();
                    bay();
                } else {
                    CipherChoice.bruteForce();
                    bay();
                }
            } else {
                bay();
            }
        }
    }

    public static boolean question() {
        Scanner scanner = new Scanner(System.in);
        boolean yesOrNot = false;
        String answer;
        while (true) {
            answer = scanner.nextLine();
            if ("y".equalsIgnoreCase(answer)) {
                yesOrNot = true;
                break;
            } else if ("n".equalsIgnoreCase(answer)) {
                yesOrNot = false;
                break;
            } else if ("exit".equalsIgnoreCase(answer)) {
                System.out.println(BAY);
                System.exit(2);
                break;
            } else {
                System.out.println("Ответ " + answer + " не корректный!\n" + YES_OR_NO);
            }
        }
        return yesOrNot;
    }

    public static void hello(){
        System.out.println("Добро пожаловать в мир шифрования!\n" +
                "Вы хотите зашифровать текст?\n" + YES_OR_NO + EXIT);
    }

    public static void doYouHaveKey() {
        System.out.println("У вас есть ключ шифрования?\n" + YES_OR_NO + EXIT);
    }

    public static void enterKey() {
        System.out.println("Пожалуйста введите целое число от "
                + -Alfabet.size() + " до " + Alfabet.size());
    }

    public static void pathIn() {
        System.out.println(PATH_IN + EXIT);
    }

    public static void pathOut() {
        System.out.println(PATH_OUT + EXIT);
    }

    public static void randomKey() {
        System.out.println("Ключ будет сгенерирован случайным образом из диапазона возможных");
    }

    public static void keyFind(int k) {
        System.out.println("Ключ подобран, он равен - " + k);
    }

    public static void doYouNeedDecoding (){
        System.out.println("Вы хотите расшифровать текст? \n" + YES_OR_NO + EXIT);
    }

    public static void exceptionMessageIO(String message) {
        System.err.println("Произошла ошибка чтения файла! Проверьте кодировку файла! " + message);
    }

    public static void notReadableFile() {
        System.out.println("Невозможно прочитать файл");
    }

    public static void haveNoFile (Path path){
        System.out.println("Файла с путем " + path + " не существует, попробуйте еще раз!\n" + EXIT);
    }

    public static void isDirectory (Path path){
        System.out.println(path + " является директорией, введите полный путь к файлу!\n" + EXIT);
    }

    public static void invalidPath (String message){
        System.err.println("Путь не может быть сконвертирован " + message);
    }

    public static void wrongKey(int k){
        System.out.println("Число " + k + " выходит из диапазона ключей! Попробуйте еще раз!");
    }

    public static void notInt(int k){
        System.err.println(k + "- не целое число! Попробуйте еще раз!");
    }

    public static void outputException (String message){
        System.err.println("Произошла ошибка вывода!" + message);
    }

    public static void outputIllegalArgumentException (String message){
        System.err.println("Произошла ошибка исходных данных!" + message);
    }

    public static void bay() {
        System.out.println(BAY);
        System.exit(0);
    }

}


