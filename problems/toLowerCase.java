public class toLowerCase {
    public String toLowerCase(String str) {
        
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            //all uppercase alphabetical character codes fall between 65 - 90, shift code by 32
            if (letters[i] >= 65 && letters[i] <= 90) {
                letters[i] += 32;
            }

        }
        return new String(letters);
    }
}
