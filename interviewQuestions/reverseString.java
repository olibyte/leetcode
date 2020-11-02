package interviewQuestions;

public class reverseString {
    public void reverseString(char[] s) {
        int n = s.length -1;
        for (int i = 0; i < s.length/2; i++) {            
            char tmp = s[i];
            s[i] = s[n];
            s[n] = tmp;
            n--;
        }
    }
}
