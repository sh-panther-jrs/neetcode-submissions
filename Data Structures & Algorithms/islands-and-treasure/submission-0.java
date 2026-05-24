class Solution {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> allChest = getAllChest(grid);
        int dist = 0;
        while(!allChest.isEmpty()) {
            int length = allChest.size();
            
            for (int i=0; i<length;i++) {
                int [] rowCol = allChest.remove();
                int row = rowCol[0];
                int col = rowCol[1];
                if (grid[row][col]==Integer.MAX_VALUE) {
                    grid[row][col] = dist;
                }
                for (int [] dir:direction) {
                    if (isValid(row+dir[0], col+dir[1], grid.length, grid[0].length) && grid[row+dir[0]][col+dir[1]]==Integer.MAX_VALUE) {
                        int neigh[] = {row+dir[0], col+dir[1]};
                        allChest.add(neigh);
                    }
                } 
            }
            dist++;
        }
        // Find all the chests. 
        // Taking chest as source, try to reach all the non-visited land and update with min.
        // 
    }

    private boolean isValid(int m, int n, int totRow, int totCol) {
        return m>=0 && n>=0 && m<totRow && n<totCol;
    }
    private Queue<int[]> getAllChest(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int row=0; row< rows; row++) {
            for (int col=0; col<colums; col++) {
                if (grid[row][col]==0) {
                    int [] chest = {row, col};
                    queue.offer(chest);
                }
            }
        }
        return queue;
    }
}
