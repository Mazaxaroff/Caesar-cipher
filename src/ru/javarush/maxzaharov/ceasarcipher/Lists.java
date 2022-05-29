package ru.javarush.maxzaharov.ceasarcipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static List<String> listFromFile(Path path) {
        List<String> listFrom = new ArrayList<>();
        if (Files.isReadable(path)) {
            try {
                listFrom = Files.readAllLines(path);
            } catch (IOException e) {
                Dialog.exceptionMessageIO(e.getMessage());
                System.exit(3);
            }
        } else {
            Dialog.notReadableFile();
        }
        return listFrom;
    }

    public static List<String> cipherList(int key) {
        List<String> ciphList = new ArrayList<>();
        for (String stringOfText : Lists.listFromFile(PathKeeper.pathOfFileIn())) {
            ciphList.add(CipherDecipher.cihper(stringOfText, key));
        }
        return ciphList;
    }

    public static List<String> decipherList(int key) {
        List<String> deciphList = new ArrayList<>();
        for (String stringOfText : Lists.listFromFile(PathKeeper.pathOfFileIn())) {
            deciphList.add(CipherDecipher.decihper(stringOfText, key));
        }
        return deciphList;
    }
}
