public class BruteForce {

    public String bruteForceDecrypt(String encryptedText) {

        Cipher cipher = new Cipher();

        StringBuilder result = new StringBuilder();

        for (int key = 0; key < Cipher.getAlphabetSize(); key++) {

            result.append("Ключ ");
            result.append(key);
            result.append(":\n");

            String decryptedText = cipher.decrypt(encryptedText, key);

            result.append(decryptedText);
            result.append("\n");
            result.append("----------------------------------");
            result.append("\n");
        }

        return result.toString();
    }
}