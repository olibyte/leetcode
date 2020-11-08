public class insertionSort {
    /** Insertion-sort of an array of characters into nondecreasing order */
    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) { // begin with second character
            char cur = data[k]; // time to insert cur = data[k]
            int j = k; // find correct index j for cur
            while (j > 0 && data[j - 1] > cur) { // thus, data[j-1 must go after cur]
                data[j] = data[j - 1]; // slide data[j-1] rightward
                j--; // and consider previous j for cur
            }
            data[j] = cur; // this is the proper place for cur
        }
    }

    public static void insertionSortMem(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            // [2,7,3,10,1]
            char card = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > card) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = card;
        }
    }
    public static void insertionSort1(char[] data) {
        int n = data.length;
        for (int k = 0; k < n; k++) {
            char card = data[k];
            int j = k;
            while (j > 0 && data[j] > card) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = card;
        }
    }
}
/** Class for doing encryption and decryption using the Caesar Cipher */
class CaesarCipher {
    protected char[] encoder = new char[26];    //Encryption array
    protected char[] decoder = new char[26];    //Decryption array
    /** Constructor that initializes the encryption and decryption arrays */
    public CaesarCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char)('A' + (k + rotation) % 26);
            decoder[k] = (char)('A' + (k - rotation + 26) % 26);
        }
    }
    /** Returns String representing encrypted message */
    public String encrypt(String message) {
        return transform(message, encoder);
    }
    /** Returns decrypted message given encrypted secret */
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }
    /** Return transformation of original String using given code */
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {
            if (Character.isUpperCase(msg[k])) {    //we have a letter to change
                int j = msg[k] - 'A';               //will be value from 0 to 25
                msg[k] = code[j];                   //replace the character
            }
        }
        return new String(msg);
    }
}
