package interviewQuestions;

import java.util.HashSet;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashSet<Integer> [] row = new HashSet[9];
        HashSet<Integer> [] col = new HashSet[9];
        HashSet<Integer> [] box = new HashSet[9];
        for (int i = 0; i < 9; i++) {
          row[i] = new HashSet<Integer>();
          col[i] = new HashSet<Integer>();
          box[i] = new HashSet<Integer>();
        }
    
        // validate a board
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            char num = board[i][j];
            if (num != '.') {
              int n = (int)num;
              int box_index = (i / 3 ) * 3 + j / 3;
    
             if((!row[i].add(n))
                    ||
                (!col[j].add(n))
                    ||
                (!box[box_index].add(n))){
                    return false;
              }
                
            }
          }
        }
        return true;
      }
}
