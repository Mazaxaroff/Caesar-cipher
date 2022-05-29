package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteToFile {
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
