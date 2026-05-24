class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int prevPrev=nums[0];
        int prev = Math.max(nums[1], nums[0]);
        int index=2;
        while(index<nums.length) {
            int currVal = Math.max(prev, prevPrev+nums[index]);
            prevPrev=prev;
            prev=currVal;
            index++;
        }
        return Math.max(prev, prevPrev);
    }
}
