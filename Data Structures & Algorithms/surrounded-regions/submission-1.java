class Solution {
    public void solve(char[][] board) {
        int row = board.length, column = board[0].length;
        boolean[][] isVisited = new boolean[row][column];
        // First & Last column
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O') dfs(i, 0, board, isVisited);
            if(board[i][column-1] == 'O') dfs(i, column-1, board, isVisited);
        }

        // First & Last row
        for(int j = 0; j < column; j++){
            if(board[0][j] == 'O') dfs(0, j, board, isVisited);
            if(board[row-1][j] == 'O') dfs(row-1, j, board, isVisited);
        }

        for(int i = 0; i < row; i++){   
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X'; // surrounded
                } else if(board[i][j] == 'T'){
                    board[i][j] = 'O'; // restore safe
                }
            }
        }
        
    }

    private void dfs(int row, int column, char[][] board, boolean[][] isVisited){
        
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length
            || board[row][column] != 'O' || isVisited[row][column]) {
                return;
        }

        isVisited[row][column] = true;

        board[row][column] = 'T'; // mark safe

        dfs(row+1, column, board, isVisited);
        dfs(row-1, column, board, isVisited);
        dfs(row, column+1, board, isVisited);
        dfs(row, column-1, board, isVisited);
    }
}
