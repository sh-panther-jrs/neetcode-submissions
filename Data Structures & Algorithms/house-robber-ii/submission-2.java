class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1) {
            return nums[0];
        }
        int n_0selected = getOptimal(0, nums, nums.length-2);
        int n_1selected = getOptimal(1, nums, nums.length-1);
        return Math.max(n_1selected, n_0selected);
    }

    private int getOptimal(int startIndex, int nums[], int endIndex) {
        int prevPrev = 0;
        int prev = 0;
        while(startIndex<=endIndex) {
            int currMax = Math.max(prev, prevPrev+nums[startIndex]);
            prevPrev = prev;
            prev = currMax;
            startIndex++;
        }
        return prev;
    }
}
