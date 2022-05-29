package ru.javarush.maxzaharov.ceasarcipher;

import java.util.ArrayList;
import java.util.List;

public class Alfabet {
    public static List<Character> alfabet() {
        List<Character> alfabet = new ArrayList<>();
        for (char i = 'А'; i <= 'я'; i++) {
            alfabet.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            alfabet.add(i);
        }
        alfabet.add('.');
        alfabet.add(',');
        alfabet.add('"');
        alfabet.add(':');
        alfabet.add(';');
        alfabet.add('-');
        alfabet.add('!');
        alfabet.add('?');
        alfabet.add(')');
        alfabet.add('(');
        alfabet.add(' ');
        return alfabet;
    }

    public static int sizeOfAlfabet(){
        return alfabet().size();
    }
}
