class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, column = grid[0].length;
       
        Queue<int[]> queue = new LinkedList<>();
        //1. Add all the water position into the queue
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==0)
                queue.add(new int[]{i, j});
            }
        }
       
       //2. Define direction
       int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};

       while(!queue.isEmpty()){
            int[] val = queue.poll();
            int r = val[0];
            int c = val[1];

            for(int[] dir: directions){
                int newR = r+dir[0];
                int newC = c+dir[1];

                //3. Boundary check
                if(newR<0 || newC<0 || newR>=row || newC>=column)
                continue;

                //4. Process only Integer MAX_VALUE cells
                if(grid[newR][newC] == Integer.MAX_VALUE){
                    grid[newR][newC] = grid[r][c] + 1;
                    queue.add(new int[]{newR, newC});
                }
            }

       }
        
    }
}
