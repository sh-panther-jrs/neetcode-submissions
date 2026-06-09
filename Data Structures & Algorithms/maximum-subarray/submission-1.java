class Solution {
    public int maxSubArray(int[] nums) {
        int end=0;
        int currSum=0;
        int maxSum=nums[0];
        while(end<nums.length) {
            
            if(currSum<0) {
                currSum=0;
            }
            currSum+=nums[end];
            maxSum = Math.max(maxSum, currSum);
            end++;
        }
        return maxSum;
    }
}
