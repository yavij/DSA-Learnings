class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length, column = board[0].length;
        char[] wordArray = word.toCharArray();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                 if(backtrack(i, j, board, wordArray, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, char[][] board, char[] word, int k){
        if(k == word.length) return true;
            if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
            if(board[i][j] != word[k]) return false;
            char temp = board[i][j];
            board[i][j] = '#';
            if(
            backtrack(i+1, j, board, word, k+1) ||
            backtrack(i-1, j, board, word, k+1) ||
            backtrack(i, j+1, board, word, k+1) ||
            backtrack(i, j-1, board, word, k+1)
            ){
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
