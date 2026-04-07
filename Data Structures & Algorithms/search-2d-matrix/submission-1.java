class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length, column = matrix[0].length;

        for(int i=0; i<row; i++){
            if(matrix[i][0] == target){
                return true;
            }else if(matrix[i][0] > target){
                continue;
            }else{
                for(int k=0;k<column;k++){
                    if(matrix[i][k]== target) return true;
                }
            }
        }
        return false;   
    }
}
