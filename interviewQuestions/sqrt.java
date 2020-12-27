package interviewQuestions;

public class sqrt {
    public int mySqrt(int x) {
        long left = 1, right = x, result = 0;
        if(x <= 1)
            return (int)x;
        
        while(left<=right){
            long mid = (left+right)/2;
            
            if(mid*mid==x)
                return (int)mid;
            else if(mid*mid <x){
                left=mid+1;
                result = mid;
            }else{
                right=mid-1;
            }
        }
        return (int)result;
    }
}
