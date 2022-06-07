package ru.javarush.maxzaharov.ceasarcipher;

import java.util.ArrayList;
import java.util.List;

public class CipherChoice {

    public static void encodingWithKey() {
        encoding(false);
    }

    public static void encodingWithoutKey() {
        encoding(true);
    }

    public static void decodingWithKey() {
        FileProcess.write(FileProcess.createDecodedList(Keys.get(false)), PathKeeper.outputPath());
    }

    public static void bruteForce() {
        int bruteForceKey;
        List<String> inputList = FileProcess.read(PathKeeper.inputPath());
        for (int i = 1; i < Alfabet.size(); i++) {
            for (String stringOfText : inputList) {
                if (compare(CaesarCipher.process(stringOfText, -i), Dictionary.getInstance())) {
                    bruteForceKey = i;
                    Dialog.keyFind(bruteForceKey);
                    List<String> outputList = new ArrayList<>();
                    for (String originalString : inputList) {
                        outputList.add(CaesarCipher.process(originalString, -bruteForceKey));
                    }
                    FileProcess.write(outputList, PathKeeper.outputPath());
                    break;
                }
            }
        }
    }

    public static boolean compare(String check, String[] dictionary) {
        boolean isEquals = false;
        for (String s : dictionary) {
            if (check.indexOf(s) != -1) {
                isEquals = true;
                break;
            }
        }
        return isEquals;
    }

    private static void encoding(boolean keyIsRandom) {
        FileProcess.write(FileProcess.createEncodedList(Keys.get(keyIsRandom)), PathKeeper.outputPath());
    }

}
