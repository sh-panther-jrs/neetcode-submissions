class Solution {
    int[][] directions = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    public int orangesRotting(int[][] grid) {
        int countFresh=0;
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int row=0; row<rows;row++) {
            for(int col=0; col<cols; col++) {
                if (grid[row][col]==2) {
                    queue.offer(new int[] {row, col});
                } else if (grid[row][col]==1) {
                    countFresh++;
                }
            }
        }
        int dist=0;
        while(!queue.isEmpty()) {
            boolean found=false;
            int len = queue.size();
            for (int i=0; i<len;i++) {
                int[] currRowCol= queue.remove();
                for(int[] dir: directions) {
                    int neighbourRow = currRowCol[0] + dir[0];
                    int neighbourCol = currRowCol[1] + dir[1];
                    if (isValid(neighbourRow,neighbourCol, rows, cols)) {
                        if (grid[neighbourRow][neighbourCol]==1){
                            grid[neighbourRow][neighbourCol] = 2;
                            countFresh--;
                            found=true;
                            queue.offer(new int[]{neighbourRow, neighbourCol});
                        }
                    }
                }
            }
            if (found) {
                dist++;
            }

        }
        if (countFresh!=0) {
            return -1;
        }
        return dist;
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row>=0 && col>=0 && row<rows && col<cols;
    }
}
