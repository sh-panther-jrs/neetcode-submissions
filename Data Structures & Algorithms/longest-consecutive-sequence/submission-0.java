class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num:nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);
        }
        int longest = 0;
        for (int num:nums) {
            if (!hashMap.containsKey(num-1)) {
                longest = Math.max(longest, getMaxLength(num, hashMap));
            }
        }
        return longest;
    }
    private int getMaxLength(int num, Map<Integer, Integer> m) {
        int longest = 1;
        while(m.containsKey(num+1)){
            longest++;
            num++;
        }
        return longest;
    }
}
