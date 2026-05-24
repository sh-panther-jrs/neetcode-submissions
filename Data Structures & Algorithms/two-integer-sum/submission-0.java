class Solution {
    public int[] twoSum(int[] nums, int target) {
        int output[] = new int[2];
        HashMap<Integer, Integer> indexFound = new HashMap<>();
        for (int index=0; index<nums.length; index++) {
            if (indexFound.containsKey(target-nums[index])) {
                output[0] = indexFound.get(target-nums[index]);
                output[1] = index;
                return output;
            }
            indexFound.putIfAbsent(nums[index], index);
        }
        return output;
    }
}
