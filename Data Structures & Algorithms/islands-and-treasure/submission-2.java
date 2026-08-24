class Solution {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public void islandsAndTreasure(int[][] grid) { 
        Queue<int[]> treasureChests = getAlltreasureChest(grid);
        int dist=1;
        while(!treasureChests.isEmpty()) {
            int currLevelSize = treasureChests.size();
            
            for(int i=0; i< currLevelSize; i++) {
                int[] treasureChest = treasureChests.poll();
                for(int dir[]:dirs) {
                    int newRow = dir[0] + treasureChest[0];
                    int newCol = dir[1] + treasureChest[1];
                    if(isValid(grid.length, grid[0].length, newRow, newCol) && grid[newRow][newCol]==Integer.MAX_VALUE) {
                        grid[newRow][newCol] = dist;
                        treasureChests.add(new int[] {newRow, newCol});
                    }
                }
            }
            dist++;
        }
    }
    private boolean isValid(int rows, int cols, int row, int col) {
        return row>=0 && row<rows && col>=0 && col<cols;
    }
	private Queue<int[]> getAlltreasureChest(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row=0 ; row<grid.length; row++) {
            for(int col=0 ; col<grid[0].length; col++) { 
                if(grid[row][col]==0) {
                   queue.add(new int[]{row, col});
                }
            }
        }
		return queue;
	}




    public void islandsAndTreasure2(int[][] grid) {
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
                    if (isValid2(row+dir[0], col+dir[1], grid.length, grid[0].length) && grid[row+dir[0]][col+dir[1]]==Integer.MAX_VALUE) {
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

    private boolean isValid2(int m, int n, int totRow, int totCol) {
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
