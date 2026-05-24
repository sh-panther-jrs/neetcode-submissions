class Solution {
    public int search(int[] nums, int target) {
        return find(0, nums.length-1, nums, target);
    }

    private int find(int low, int high, int arr[], int target) {
        if(low>high) {
            return -1;
        }
        int mid = low + ((high-low)/2);
        if(arr[mid]==target) {
            return mid;
        }
        if(arr[mid]> target) {
            return find(low, mid-1, arr, target);
        }
        else {
            return find(mid+1, high, arr, target);
        }
    }
}
