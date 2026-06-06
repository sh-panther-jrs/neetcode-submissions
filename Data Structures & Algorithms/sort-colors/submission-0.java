class Solution {
    public void sortColors(int[] nums) {
        int nextZero=0;
        int curr=0;
        int nextOne=nums.length-1;
        while(curr<=nextOne) {
            int currElem = nums[curr];
            if(currElem==0) {
                swap(curr, nextZero, nums);
                nextZero++;
                curr++;
            } else if(currElem==2) {
                swap(curr, nextOne, nums);
                nextOne--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int left, int right, int nums[]) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}