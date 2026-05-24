class Solution {
    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[0]=true;
        // dp[i] = for k=0, i, if (dp[k] && nums[k]+k>=i) dp[k]=true
        for (int i=1; i<nums.length;i++) {
            for (int k=0; k<i;k++) {
                if (dp[k] && (nums[k]+k)>=i) {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[nums.length-1];
    }
}
