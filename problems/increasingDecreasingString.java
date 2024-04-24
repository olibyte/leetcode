import java.util.HashMap;

class increasingDecreasingString {
    public String sortString(String s) {
        int [] freq = new int[26];
        for (char ch: s.toCharArray()) {
            //use 'a' offset to index our chars into a sorted array
            freq[ch - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            //walk forward through frequencies array, appending the smallest value to sb, then decrement the frequency
            for (int i=0; i<26; i++) {
                if (freq[i] > 0) {
                    //i + 'a' gives us the character value.
                    //i.e. f freq[0] == 3, append 0+'a' (typecast as a char) to sb
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
            //after a full walk forward, walkback appending the largest value to sb, then decrement the frequency
            for (int i=25; i>=0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + 'a'));
                    freq[i] -= 1;
                }
            }
        }
        return sb.toString();
    }
}