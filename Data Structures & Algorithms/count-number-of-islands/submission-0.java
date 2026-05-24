class Solution {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        Map<String, Boolean> visited = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int count =0;
        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols;col++) {
                if (grid[row][col]=='1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][]grid, int row, int col) {
        grid[row][col] ='2';    
        for(int[]dir:directions) {
            int newRow = dir[0]+row;
            int newCol = dir[1]+col;
            if(isValid(grid, newRow, newCol) && grid[newRow][newCol]=='1') {
                dfs(grid, newRow, newCol);
            }
        }
    }

    private boolean isValid(char [][]grid, int row, int col) {
        return row>=0 && col>=0 && grid.length>row && grid[0].length>col;
    }
}
