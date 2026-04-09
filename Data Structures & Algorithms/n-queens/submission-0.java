class Solution {

    private List<List<String>> results;

    public Solution(){
        this.results = new ArrayList<>();
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
          Arrays.fill(board[i], '.');
        }
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
                board[row][col] = 'Q';
                backtrack(row + 1, board);
                board[row][col] = '.'; // undo
            }
        }
    }

    private boolean isSafe(int row, int column, char[][] board){
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') return false;
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> result = new ArrayList<>();
       for (int i = 0; i < board.length; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}
