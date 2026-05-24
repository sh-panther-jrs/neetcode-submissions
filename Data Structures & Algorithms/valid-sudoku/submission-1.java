class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer> rowDs = new HashMap<>();
        Map<Integer, Integer> colDs = new HashMap<>();
        Map<Integer, Integer> squareDs = new HashMap<>();
        int rows = board.length;
        int cols = board[0].length;
        if (rows%3!=0 || cols%3!=0) {
            return false;
        }
        for (int square =0; square<rows; square++) {
            for (int row=0;row<3; row++) {
                for (int col=0;col<3; col++) {
                    int currRow = (square/3)*3+row;
                    int currCol = (square%3)*3+col;
                    if (board[currRow][currCol]=='.') {
                        continue;
                    }
                    int boardNum = board[currRow][currCol]-'1';
                    int bitNum = 1<<boardNum;
                    if((rowDs.getOrDefault(currRow, 0) & bitNum) > 0 || 
                    (colDs.getOrDefault(currCol, 0) & bitNum) > 0 || 
                    (squareDs.getOrDefault(square, 0) & bitNum) > 0) {
                        return false;
                    }
                    rowDs.put(currRow, rowDs.getOrDefault(currRow, 0)|bitNum);
                    colDs.put(currCol, colDs.getOrDefault(currCol, 0)|bitNum);
                    squareDs.put(square, squareDs.getOrDefault(square, 0)|bitNum);

                }
            }
        }
        return true;
    }
}
