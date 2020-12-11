package interviewQuestions;

public class plusOne {
    public int[] plusOne(int[] digits) {
        int size = digits.length -1;
        for (int i = size; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                //set last digit to 0
                digits[i] = 0;
                //if this the first digit
                if (i == 0) {
                    int[] newDigits = new int[size+2];
                    newDigits[0] = 1;
                    digits = newDigits;
                }
            }
        }
        return digits;
    }
}
