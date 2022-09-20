package ceasarcipher;


public class CaesarCipher {

    public static String process(String inputText, int shift) {
        StringBuilder codedString = new StringBuilder();
        for (char symbol : inputText.toCharArray()) {
            if (Alfabet.get().contains(symbol)) {
                int encodedSymbolIndex = (Alfabet.get().indexOf(symbol) + (Alfabet.size()+ shift)) % Alfabet.size();
                char encodedSymbol = Alfabet.get().get(encodedSymbolIndex);
                codedString.append(encodedSymbol);
            } else {
                codedString.append(symbol);
            }
        }
        return codedString.toString();
    }

}
