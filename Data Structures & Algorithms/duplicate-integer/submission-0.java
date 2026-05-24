class Solution {
    Map<Integer, Boolean> containss=new HashMap<>();
    public boolean hasDuplicate(int[] nums) {
        for (int num:nums) {
            if (containss.containsKey(num)) {
                return true;
            }
            containss.put(num, true);
        }
        return false;
        
    }
}