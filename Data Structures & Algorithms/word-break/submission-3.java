class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0]= true;
        int minLength = getMinLength(wordDict);
        for(int i=minLength; i<=s.length(); i++) {
            for(String word: wordDict) {
                if (i-word.length()>=0 && s.substring(i-word.length(), i).equals(word)
                ) {
                    dp[i]= dp[i-word.length()] || dp[i];
                }
            }
        }
        return dp[s.length()];
    }

    private int getMinLength(List<String> wordDict) {
        int length=0;
        for(String word: wordDict) {
            length = Math.min(length, word.length());
        }
        return length;
    }
}
