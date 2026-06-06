class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length-1, nums);
        return nums;
    }

    private void quickSort( int left, int right, int nums[]) {
        if(left<right) {
            int partitionIndex = getPIndex(left, right, nums);
            swap(partitionIndex, left, nums);
            quickSort(left, partitionIndex-1, nums);
            quickSort(partitionIndex+1, right, nums);
        }
    }

    private int getPIndex(int left, int right, int[]nums) {
        int pivotElement = nums[left];
        int curr=left+1;
        while(curr<=right) {
            int currElem = nums[curr];
            if(currElem>pivotElement) {
                swap(curr, right, nums);
                right--;
            } else {
                curr++;
            }
        }
        return right;
    }
    private void swap(int left, int right, int[]nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
