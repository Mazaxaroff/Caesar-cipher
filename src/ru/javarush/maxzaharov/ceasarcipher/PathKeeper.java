package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathKeeper {
    public static Path pathOfFileIn() {
        Scanner scanner = new Scanner(System.in);
        Dialog.pathIn();
        String path;
        do {
            path = scanner.nextLine();
            if ("exit".equals(path)) {
                Dialog.goodbay();
                System.exit(2);
            }
            try {
                Path pathOfFile = Path.of(path);
                if (!Files.exists(pathOfFile)) {
                    System.out.println("Файла с путем " + pathOfFile + " не существует, попробуйте еще раз!\n" +
                            Dialog.exit());
                } else if (!Files.isRegularFile(pathOfFile)) {
                    System.out.println(pathOfFile + " является директорией, введите полный путь к файлу!\n" +
                            Dialog.exit());
                }
            } catch (InvalidPathException e) {
                System.err.println("Путь не может быть сконвертирован");
            }
        } while (!Files.exists(Path.of(path)));
        return Path.of(path);
    }

    public static Path pathOfFileOut() {
        Scanner scanner = new Scanner(System.in);
        Dialog.pathOut();
        String path;
        do {
            path = scanner.nextLine();
            if ("exit".equals(path)) {
                Dialog.goodbay();
                System.exit(2);
            }
            try {
                Path pathOfFile = Path.of(path);
                if (!Files.exists(pathOfFile)) {
                    System.out.println("Файла с путем " + pathOfFile + " не существует, попробуйте еще раз!\n" +
                            Dialog.exit());
                } else if (!Files.isRegularFile(pathOfFile)) {
                    System.out.println(pathOfFile + " является директорией, введите полный путь к файлу!\n" +
                            Dialog.exit());
                }
            } catch (InvalidPathException e) {
                System.err.println("Путь не может быть сконвертирован");
            }
        } while (!Files.exists(Path.of(path)));
        return Path.of(path);
    }



}
