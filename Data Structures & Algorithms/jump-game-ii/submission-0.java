class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];

        for (int index=1; index<nums.length; index++) {
            int min = Integer.MAX_VALUE;
            for(int k=0; k<index;k++) {
                if ((nums[k]+k)>=index) {
                    min = Math.min(min, dp[k]+1);
                }
            }
            dp[index] = min;
        }
        return dp[nums.length-1];
    }
}
