class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Brute force solution
        int row = matrix.length;
        if(row == 0) return false;
        int column = matrix[0].length;

        /*for(int i=0; i<row; i++){
            if(matrix[i][0] == target){
                return true;
            }else if(matrix[i][0] > target){
                continue;
            }else{
                for(int k=0;k<column;k++){
                    if(matrix[i][k]== target) return true;
                }
            }
        }*/
       int mid = matrix[row/2][column/2];

       if(mid>target){
            row = row-row/2;
       }else{
        row = row+row/2;
       }

        int i = row/2;
       while(i>0 && matrix[i][0] > target){
        i--;
       }
    
       while(i >= 0){
        if(matrix[i][0] == target) return true;
            if(matrix[i][0] < target){
                for(int j=0;j<column;j++){
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
         i--;
       }
        return false;   
    }
}
