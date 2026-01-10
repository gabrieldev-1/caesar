import java.lang.Character;

public class Encryptor {
    /**
     * It receives the phrase from the text and returns the same phrase encrypted.
     * 
     * @param text text that will be encrypted
     * @param key Caesar's key
     * @return encrypted text;
     */
    public static String encrypt(String text, int key) {  
        StringBuilder encryptedText = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char destLetter;
            int posAlphabet;
            int newPos;

            if(!Character.isLetter(c)) {
                encryptedText.append(c);
                
            } else if (c >= 'a' && c <= 'z') {
                posAlphabet = c - 'a';
                newPos = (posAlphabet + (key % 26) + 26) % 26; // Calculate the new position, ensuring that the return is not negative.
                destLetter = (char) (newPos + 'a');

                encryptedText.append(destLetter);

            } else {
                posAlphabet = c - 'A';
                newPos = (posAlphabet + (key % 26) + 26) % 26;
                destLetter = (char) (newPos + 'A');

                encryptedText.append(destLetter);

            } 
        }
        return encryptedText.toString();
    }
}