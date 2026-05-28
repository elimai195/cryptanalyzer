public class Cipher {

    private static final char[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
            'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
            'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю',
            'я', '.', ',', '«', '»', '"', '\'',
            ':', '!', '?', ' '
    };

    public String encrypt(String text, int key) {
        return process(text, key);
    }

    public String decrypt(String text, int key) {
        return process(text, -key);
    }

    private String process(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for (char symbol : text.toCharArray()) {

            char lowerSymbol = Character.toLowerCase(symbol);

            int index = findIndex(lowerSymbol);

            if (index != -1) {

                int newIndex = (index + shift) % ALPHABET.length;

                if (newIndex < 0) {
                    newIndex += ALPHABET.length;
                }

                char newSymbol = ALPHABET[newIndex];

                if (Character.isUpperCase(symbol)) {
                    newSymbol = Character.toUpperCase(newSymbol);
                }

                result.append(newSymbol);

            } else {
                result.append(symbol);
            }
        }

        return result.toString();
    }

    private int findIndex(char symbol) {

        for (int i = 0; i < ALPHABET.length; i++) {

            if (ALPHABET[i] == symbol) {
                return i;
            }
        }

        return -1;
    }

    public static int getAlphabetSize() {
        return ALPHABET.length;
    }

}