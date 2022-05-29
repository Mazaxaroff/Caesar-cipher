package ru.javarush.maxzaharov.ceasarcipher;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
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
                    Dialog.haveNoFile(pathOfFile);
                } else if (!Files.isRegularFile(pathOfFile)) {
                    Dialog.isDirectory(pathOfFile);
                }
            } catch (InvalidPathException e) {
                Dialog.invalidPath(e.getMessage());
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
                    Dialog.haveNoFile(pathOfFile);
                } else if (!Files.isRegularFile(pathOfFile)) {
                    Dialog.isDirectory(pathOfFile);
                }
            } catch (InvalidPathException e) {
                Dialog.invalidPath(e.getMessage());
            }
        } while (!Files.exists(Path.of(path)));
        return Path.of(path);
    }



}
