class Solution {
    public int findMin(int[] nums) {
        int left=0; int right =nums.length-1;

        while(left<right) {
            int midIndex = left + (right-left)/2;
            int mid = nums[midIndex];
            int last = nums[right];
            if (mid<last) {
                right=midIndex;
            } else {
                left= midIndex+1;
                
            }
        }
        return nums[left];
    }
}
