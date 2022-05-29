package ru.javarush.maxzaharov.ceasarcipher;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static void cipherWithKey() {
        WriteToFile.writeToFile(Lists.cipherList(Keys.getKey(false)), PathKeeper.pathOfFileOut());
        Dialog.goodbay();
    }

    public static void cipherWithoutKey() {
        WriteToFile.writeToFile(Lists.decipherList(Keys.getKey(true)), PathKeeper.pathOfFileOut());
        Dialog.goodbay();
    }

    public static void decipherWithKey() {
        WriteToFile.writeToFile(Lists.decipherList(Keys.getKey(false)), PathKeeper.pathOfFileOut());
        Dialog.goodbay();
    }

    public static void bruteForce() {
        int bruteForceKey;
        List<String> temp = Lists.listFromFile(PathKeeper.pathOfFileIn());
        for (int i = 0; i < Alfabet.sizeOfAlfabet(); i++) {
            for (String stringOfText : temp) {
                if (compare(CipherDecipher.decihper(stringOfText, i), dictionary())) {
                    bruteForceKey = i;
                    System.out.println("Ключ подобран, он равен - " + bruteForceKey);
                    List<String> decipherList = new ArrayList<>();
                    for (String str : temp) {
                        decipherList.add(CipherDecipher.decihper(str, bruteForceKey));
                    }
                    WriteToFile.writeToFile(decipherList, PathKeeper.pathOfFileOut());
                    break;
                }
            }
        }
        Dialog.goodbay();
    }

    public static String[] dictionary() {
        return new String[] {" не ", " на ", " он ", " по ", " но ", " мы ", " из ", " то ", " за ", " от ", " ты ",
                " же ", " вы ", " бы ", " до ", " её ", " во ", " со ", " ну ", " их ", " ли ", "да "};

    }

    public static boolean compare(String check, String[] library) {
        boolean gotcha = false;
        for (String s : library) {
            if (check.indexOf(s) != -1) {
                gotcha = true;
                break;
            }
        }
        return gotcha;
    }
}
