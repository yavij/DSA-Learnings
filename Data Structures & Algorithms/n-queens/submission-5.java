class Solution {

    private List<List<String>> results;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public Solution(){
        this.results = new ArrayList<>();
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Initialize helper arrays
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        backtrack(0, board);
        return results;
    }

    private void backtrack(int row, char[][] board){
        if(row == board.length){
            results.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {

                // Place queen
                board[row][col] = 'Q';
                cols[col] = true;
                diag1[row - col + board.length] = true;
                diag2[row + col] = true;

                backtrack(row + 1, board);

                // Backtrack (undo)
                board[row][col] = '.';
                cols[col] = false;
                diag1[row - col + board.length] = false;
                diag2[row + col] = false;
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){
        return !cols[col] 
            && !diag1[row - col + board.length] 
            && !diag2[row + col];
    }

    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}
