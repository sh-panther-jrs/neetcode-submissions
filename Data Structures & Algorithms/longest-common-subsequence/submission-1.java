class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[] = new int[text2.length()+1];
        for(int row = 1; row<=text1.length(); row++) {
            int temp[] = new int[text2.length()+1];
            for(int col=1; col<=text2.length(); col++) {
                if(text1.charAt(row-1)==text2.charAt(col-1)) {
                    temp[col]=1+dp[col-1];
                    System.out.println(dp[col]);
                } else {
                    temp[col] = Math.max(dp[col], temp[col-1]);
                }
            }
            dp = temp;
        }
        return dp[text2.length()];
    }
}
