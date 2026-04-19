class Solution {

    private int numberOfIsland = 0;
    
    public int numIslands(char[][] grid) {

        int row = grid.length, column = grid[0].length;
        boolean[][] isVisited = new boolean[row][column];
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    numberOfIsland++;
                    dfs(grid, directions, isVisited, i, j);
                }
            }
        }
        return numberOfIsland;
    }

    private void dfs(char[][] grid, int[][] directions, boolean[][] isVisited,
     int row, int column){
        
        if(row < 0 || column < 0 || row>= grid.length || column >= grid[0].length
         || grid[row][column] == '0' || isVisited[row][column]){
            return;
        }

        isVisited[row][column] = true;
        dfs(grid, directions, isVisited, row+1, column);
        dfs(grid, directions, isVisited, row-1, column);
        dfs(grid, directions, isVisited, row, column+1);
        dfs(grid, directions, isVisited, row, column-1);
    }

}
