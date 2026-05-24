class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if (nums[mid]==target) {
                return mid;
            }
            if (isLeftSorted(left, mid, nums)) {
                if (nums[left]<=target && nums[mid]>=target) {
                    right = mid-1;
                } else {
                    left=mid+1;
                }
            } else {
                if (nums[mid]<=target && target<=nums[right]) {
                    left=mid+1;
                } else {
                    right =mid-1;
                }
            }
        }
        return -1;
    }
    private boolean isLeftSorted(int left, int mid, int[]nums) {
        if (left==mid) {
            return true;
        }
        return nums[left]<=nums[mid];
    }
    
    private boolean isRightSorted(int mid, int right, int[]nums) {
        if (mid==right) {
            return true;
        }
        return nums[mid]<=nums[right];
    }

}
