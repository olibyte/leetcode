package interviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class fractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
               return "0";
           }
            StringBuilder result = new StringBuilder();
           if((numerator < 0 && denominator < 0)|| (numerator> 0 && denominator > 0)){
               
           }else{
               result.append("-");
           }
           long q = numerator/ denominator;
           long r = numerator% denominator;
           q = Math.abs(q);
           result.append(q);
           r = Math.abs(r);
           if (r == 0)
               return result.toString();
           else {
               result.append(".");
               Map<Long, Integer> map = new HashMap<>();
               numerator= Math.abs(numerator);
               denominator = Math.abs(denominator);
               while (r != 0) {
                   if (map.containsKey(r)) {
                       int pos = map.get(r);
                       result.insert(pos, "(");
                       result.append(")");
                       break;
                   } else {
                       map.put(r,result.length());
                       r *= 10;
                       q = r / denominator;
                       r = r % denominator;
                       result.append(Math.abs(q));
                   }
               }
           }
           return result.toString();   
       }
}
