class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results = new ArrayList<>();
        int row = heights.length, column = heights[0].length;
        boolean[][] pacific = new boolean[row][column];
        boolean[][] atlantic = new boolean[row][column];

       //pacific
       for(int i = 0; i < row; i++) {
            dfs(i, 0, heights, pacific);
        }

        for(int j = 0; j < column; j++) {
            dfs(0, j, heights, pacific);
        }

       //atlantic
        for(int i = 0; i < row; i++) {
            dfs(i, column - 1, heights, atlantic);
        }

        for(int j = 0; j < column; j++) {
            dfs(row - 1, j, heights, atlantic);
        }
        
        //Final result
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    results.add(Arrays.asList(i, j));
                }
            }
        }
        return results;
        
    }

    private void dfs(int row, int column, int[][] heights, boolean[][] visited){

        if(visited[row][column]) return;
        visited[row][column] = true;

        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

        for(int[] dir: directions){
            int newRow = row + dir[0];
            int newCol = column + dir[1];

            //Edge case
            if(newRow<0||newCol<0||newRow>=heights.length||newCol>=heights[0].length)
            continue;

            if(heights[newRow][newCol] >= heights[row][column]){
                dfs(newRow, newCol, heights, visited);
            }   
        }
    }

}
