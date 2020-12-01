package interviewQuestions;

import java.util.HashSet;

public class happyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> mySet = new HashSet<>();
        if (n == 1) {
            return true;
        }
        while (n > 1) {
            if (!mySet.contains(n)) {
                mySet.add(n);
            } else {
                return false;
            }
            n = getSum(n);
        }
        return true;
    }

    public static int getSum(int n) {
        int digit = 0;
        int sum = 0;
        while (n > 0) {
            digit = n % 10;
            n = n / 10;
            sum = (int) (sum + Math.pow(digit, 2));
        }
        return sum;
    }
}
