package interviewQuestions;

public class climbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            //1
            return 1;
            //paths = 1
        }
        else if (n == 2) {
            //11
            //2
            return 2;
            //paths = 1 + 1
        }
        else if (n == 3) {
            //111
            //21
            //12
            return 3;
            //paths = 1 + 2
        }
        else {
            return climbStairs(0, n);
        }

    }
    public int climbStairs(int currentStep, int destination) {
        if (currentStep > destination) {
            return 0;
        }
        if (currentStep  == destination) {
            return 1;
        }
        return climbStairs(currentStep+1, destination) + climbStairs(currentStep+2, destination);
    }
}
