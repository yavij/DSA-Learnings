class Solution {

    private int numberOfIsland = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] isVisited = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int currentArea = dfs(grid, isVisited, directions, i, j);
                numberOfIsland = Math.max(numberOfIsland, currentArea);
            }
        }
        return numberOfIsland;
    }

    private int dfs(int[][] grid, boolean[][] isVisited, int[][] directions,
            int row, int column){
        
        if( row<0 || column>=grid[0].length || row >= grid.length ||
            column < 0 || grid[row][column] == 0 || isVisited[row][column] ){
            return 0;
        }

        isVisited[row][column] = true;
        int area = 1;

        for(int[] direction: directions){
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            area +=dfs(grid, isVisited, directions, newRow, newColumn);
        }

        return area;
    }
}
