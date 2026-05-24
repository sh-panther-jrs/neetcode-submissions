class Solution {
    static int directions[][] = {{0, -1}, {0, 1}, { -1, 0},{ 1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols; col++) {
                if (grid[row][col]==1) {
                    maxArea= Math.max(maxArea, dfs(grid, row, col));
                }
            }
        }
        return maxArea;    
    }

    private int dfs(int[][]grid, int row, int col) {
        int childArea = 1;
        grid[row][col]=2;
        for(int[]dir: directions) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if(isValid(grid, newRow, newCol) && grid[newRow][newCol]==1) {
                childArea+=dfs(grid, newRow, newCol);
            }
        }
        return childArea;
    }
    
    private boolean isValid(int[][] grid, int row, int col) {
        return row>=0 && col>=0 && row<grid.length && col<grid[0].length;
    }
}
