class Solution {
    public int countSubstrings(String s) {
        int countSubstrings =0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            dp[i][i] = true;
            countSubstrings++;
        }
        for(int i=0; i<s.length()-1; i++) {
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
            if(dp[i][i+1]) {
                countSubstrings++;
            }
        }
        for(int diff=2; diff<s.length(); diff++){
            for(int i=0; i<=s.length()-1-diff; i++){
                int j= i+diff;
                if(s.charAt(i)== s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] =true;
                    countSubstrings++;
                }
            }
        }
        return countSubstrings;
    }
}
