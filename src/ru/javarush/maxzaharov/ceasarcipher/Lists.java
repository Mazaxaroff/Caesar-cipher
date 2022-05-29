package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static List<String> listFromFile(Path path) {
        List<String> listFromFile = new ArrayList<>();
        if (Files.isReadable(path)) {
            try {
                listFromFile = Files.readAllLines(path);
            } catch (IOException e) {
                System.err.println("Произошла ошибка чтения файла! Проверьте кодировку файла! " + e.getMessage());
                System.exit(3);
            }
        } else {
            System.out.println("Невозможно прочитать файл");
        }
        return listFromFile;
    }

    public static List<String> cipherList(int key) {
        List<String> cipherList = new ArrayList<>();
        for (String stringOfText : Lists.listFromFile(PathKeeper.pathOfFileIn())) {
            cipherList.add(CipherDecipher.cihper(stringOfText, key));
        }
        return cipherList;
    }

    public static List<String> decipherList(int key) {
        List<String> decipherList = new ArrayList<>();
        for (String stringOfText : Lists.listFromFile(PathKeeper.pathOfFileIn())) {
            decipherList.add(CipherDecipher.decihper(stringOfText, key));
        }
        return decipherList;
    }
}
