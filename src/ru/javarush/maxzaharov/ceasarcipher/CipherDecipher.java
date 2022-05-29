package ru.javarush.maxzaharov.ceasarcipher;

import java.util.*;

public class CipherDecipher {

    public static String cihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Alfabet.alfabet().contains(ch)) {
                char newChar = Alfabet.alfabet().get((Alfabet.alfabet().indexOf(ch) + shift) % Alfabet.sizeOfAlfabet());
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static String decihper(String s, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Alfabet.alfabet().contains(ch)) {
                char newChar = Alfabet.alfabet().get((Alfabet.alfabet().indexOf(ch) + (Alfabet.sizeOfAlfabet()
                        - shift)) % Alfabet.sizeOfAlfabet());
                stringBuilder.append(newChar);
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


}
