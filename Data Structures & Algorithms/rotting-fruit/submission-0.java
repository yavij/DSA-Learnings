class Solution {
    public int orangesRotting(int[][] grid) {

        int row = grid.length, column = grid[0].length;
        int[][] directions = {{0,-1}, {0,1}, {1, 0}, {-1,0}};

        //1. Note all the rooten fruits into the queue;
        Queue<int[]> rotten = new LinkedList<>();

        //2. Count fresh fruits
        int freshFruits = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.println(i+" "+j);
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    freshFruits++;
                }
            }
        }

        // Edge case
        if(freshFruits == 0) return 0;

        int minutes = 0;

        //3. Rot all the fresh where rotten fruits is there.
        while(!rotten.isEmpty()){

            int size = rotten.size();
            boolean rotted = false;
            
             for(int i = 0; i < size; i++){
                int[] val = rotten.poll();
                int r = val[0];
                int c = val[1];

                for(int[] dir: directions){
                    int newR = r+dir[0];
                    int newC = c+dir[1];

                    if(newR<0 || newC<0 || newR>=row || newC>= column) continue;

                    if(grid[newR][newC] == 1){
                            grid[newR][newC] = 2;
                            rotten.add(new int[]{newR, newC});
                            freshFruits--;
                            rotted = true;
                    }
                }
            }
            if(rotted) minutes++;
        }

       return freshFruits == 0 ? minutes : -1;
        
    }
}
