package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        List<Integer> row3 = new ArrayList<>();
        List<Integer> row4 = new ArrayList<>();
        List<Integer> row5 = new ArrayList<>();
        //[1]
        row1.add(1);
        //[1,1]
        row2.add(1); //sum of row1[0]
        row2.add(1);//sum of row1[0]
        //[1,2,1]
        row3.add(1); //sum of row2[0]
        row3.add(2);//sum of row2[0] + row2[1]
        row3.add(1);//sum of row2[1]

        //[1,3,3,1]
        row4.add(1); //sum of row3[0]
        row4.add(3); //sum of row3[0]+ row3[1]
        row4.add(3); //sum of row3[1]+row3[2]
        row4.add(1); //sum of row3[2]

        //[1,4,6,4,1]
        row5.add(1); //sum of row4[0]
        row5.add(4); //sum of row4[0] + row4[1]
        row5.add(6); //sum of row4[1] + row4[2]
        row5.add(4); //sum of row4[2] + row4[3]
        row5.add(1); //sum of row4[3]
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row)
        }
        result.add(row1);
        //[1]
        //
        
        return result;
        
    }
}
