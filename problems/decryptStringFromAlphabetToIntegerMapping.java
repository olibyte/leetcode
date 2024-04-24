import java.util.HashMap;

public class decryptStringFromAlphabetToIntegerMapping {
  public String freqAlphabets(String s) {
    String result = "";
    //walk backwards
    for (int i = s.length() - 1; i >= 0;) {
      int alphabet_index = 0;
      if (s.charAt(i) == '#') {
        alphabet_index = Integer.parseInt(s.substring(i-2, i)) - 1;
        i -= 3;
      } else {
        alphabet_index = Integer.parseInt(Character.toString(s.charAt(i--))) - 1;
      }
      result = (char)((int)'a' + alphabet_index) + result;
    }
    return result;
  }  
}