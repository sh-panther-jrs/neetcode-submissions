class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        int max =1;
        for(int i=1; i<nums.length; i++) {
            if(dp.get(dp.size()-1)<nums[i]) {
                max++;
                dp.add(nums[i]);
                continue;
            }
            int findIndex = Collections.binarySearch(dp, nums[i]);
            if(findIndex<0) {
                findIndex=~findIndex;
            }
            dp.set(findIndex, nums[i]);
        }
        return max;
    }
}
