class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1) {
            return nums[0];
        }
        int n_0selected = helper(0, nums.length-2, nums);
        int n_1selected = helper(1, nums.length-1, nums);
        return Math.max(n_1selected, n_0selected);
    }

    private int helper(int start, int end, int[]nums) {
        int[] dp = new int[end-start+1];
        if(dp.length==0) {
            return 0;
        }
        if(dp.length==1) {
            return nums[start];
        }
        int index=0;
        dp[index] = nums[start];
        dp[index+1] = Math.max(nums[start], nums[start+1]);
        
        start+=2;
        index+=2;
        while(start<=end) {
            dp[index] = Math.max(dp[index-1], dp[index-2] + nums[start]);
            start++;
            index++;
        }
        return dp[dp.length-1];
    }



    // private int getOptimal(int startIndex, int nums[], int endIndex) {
    //     int prevPrev = 0;
    //     int prev = 0;
    //     while(startIndex<=endIndex) {
    //         int currMax = Math.max(prev, prevPrev+nums[startIndex]);
    //         prevPrev = prev;
    //         prev = currMax;
    //         startIndex++;
    //     }
    //     return prev;
    // }
}
