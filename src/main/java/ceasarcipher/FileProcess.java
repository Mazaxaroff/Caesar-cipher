package ceasarcipher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileProcess {
    public static void write(List<String> codedList, Path outputPath) {
        try {
            Files.write(outputPath, codedList, StandardCharsets.UTF_8);
        } catch (IOException e) {
           Dialog.outputException(e.getMessage());

        } catch (IllegalArgumentException e) {
            Dialog.exceptionMessage(e.getMessage());
        }
    }

    public static List<String> read(Path inputPath) {
        List<String> inputList = new ArrayList<>();
        if (Files.isReadable(inputPath)) {
            try {
                inputList = Files.readAllLines(inputPath);
            } catch (IOException e) {
                Dialog.exceptionMessageIO(e.getMessage());
                System.exit(1);
            }
        } else {
            Dialog.notReadableFile();
        }
        return inputList;
    }

    public static List<String> createEncodedList(int key) {
        return createTextList(key);
    }

    public static List<String> createDecodedList(int key) {
        return createTextList(-key);
    }

    public static List<String> createTextList(int key) {
        List<String> result = new ArrayList<>();
        for (String stringOfText : read(PathKeeper.inputPath())) {
            result.add(CaesarCipher.process(stringOfText, key));
        }
        return result;
    }

}
