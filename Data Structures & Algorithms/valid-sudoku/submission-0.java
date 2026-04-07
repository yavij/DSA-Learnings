class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length, column = board[0].length;

        //Row
        for(int i=0;i<row;i++){
            Set<Character> values = new HashSet<>();
            for(int j=0;j<column;j++){
                if(board[i][j] == '.') continue;
                if(values.contains(board[i][j])){
                    return false;
                }
                values.add(board[i][j]);
            }
        }

        //Column
        for(int i=0;i<column;i++){
            Set<Character> values = new HashSet<>();
            for(int j=0;j<row;j++){
                if(board[j][i] == '.') continue;
                if(values.contains(board[j][i])){
                    return false;
                }
                values.add(board[j][i]);
            }
        }

        //3*3
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {

                Set<Character> values = new HashSet<>();

                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {

                        if (board[i][j] == '.') continue;

                        if (values.contains(board[i][j])) {
                            return false;
                        }

                        values.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
