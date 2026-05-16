class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : directions) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshCount--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}