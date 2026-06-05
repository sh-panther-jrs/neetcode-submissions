class Solution {
    public int removeElement(int[] nums, int val) {
        int end = nums.length-1;
        int start=0;
        int count=0;
        while(end>=start){
            if(nums[start]==val) {
                swap(start, end, nums);
                count++;
                end--;
            } else {
                start++;
            }
        }
        return nums.length-count;
    }
    private void swap(int s, int e, int nums[]) {
        int temp = nums[s];
        nums[s]=nums[e];
        nums[e] = temp;
    }
}