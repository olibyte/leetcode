package interviewQuestions;

public class surroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        // Mark any connected cell to a border cell with value 'O' as safe
        // left and right borders
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // top and bottom borders
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // Any 'O' left now are the ones that can be captured
        // Mark those as captured and revert the cells marked as safe to 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                } // else cell is X
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (board[r][c] != 'O') {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        board[r][c] = 'S';

        // right
        if (c + 1 < cols) {
            dfs(board, r, c + 1);
        }
        // bottom
        if (r + 1 < rows) {
            dfs(board, r + 1, c);
        }
        // left
        if (c - 1 >= 0) {
            dfs(board, r, c - 1);
        }
        // top
        if (r - 1 >= 0) {
            dfs(board, r - 1, c);
        }
    }
}
