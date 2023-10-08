package ceasarcipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alfabet {
    private static final List<Character> ALPHABET;

    static {
        List<Character> alphabet = new ArrayList<>();
        for (char i = 'А'; i <= 'я'; i++) {
            alphabet.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            alphabet.add(i);
        }
        alphabet.add('.');
        alphabet.add(',');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add(';');
        alphabet.add('-');
        alphabet.add('!');
        alphabet.add('?');
        alphabet.add(')');
        alphabet.add('(');
        alphabet.add(' ');
        ALPHABET = Collections.unmodifiableList(alphabet);
    }

    public static List<Character> get() {
        return ALPHABET;
    }

    public static int size() {
        return ALPHABET.size();
    }

}
