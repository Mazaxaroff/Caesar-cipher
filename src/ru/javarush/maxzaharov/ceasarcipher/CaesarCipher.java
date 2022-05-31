package ru.javarush.maxzaharov.ceasarcipher;


public class CaesarCipher {

    public static String process(String inputText, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char symbol : inputText.toCharArray()) {
            if (Alfabet.get().contains(symbol)) {
                int encodedSymbolIndex = (Alfabet.get().indexOf(symbol) + (Alfabet.size()+ shift)) % Alfabet.size();
                char encodedSymbol = Alfabet.get().get(encodedSymbolIndex);
                stringBuilder.append(encodedSymbol);
            } else {
                stringBuilder.append(symbol);
            }
        }
        return stringBuilder.toString();
    }

}
