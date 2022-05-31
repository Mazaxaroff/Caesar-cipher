package ru.javarush.maxzaharov.ceasarcipher;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class PathKeeper {
    public static Path inputPath() {
        Dialog.pathIn();
        return pathRequest();
    }

    public static Path outputPath() {
        Dialog.pathOut();
        return pathRequest();
    }

    public static Path pathRequest() {
        Scanner scanner = new Scanner(System.in);
        String path;
        do {
            path = scanner.nextLine();
            if ("exit".equals(path)) {
                Dialog.bay();
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
