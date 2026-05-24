class Solution {
    public int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        Arrays.fill(prev, 1);
        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++) {
                if(col==0) {
                    prev[0]=1; 
                    continue;
                } 
                prev[col]= prev[col-1] + prev[col];
            }
        }
        return prev[n-1];
    }
}
