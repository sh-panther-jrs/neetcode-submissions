class Solution {
    public int[] getConcatenation(int[] nums) {
        int output[]= new int[nums.length*2];
        for (int i=0;i<2;i++) {
            for(int j=0;j<nums.length;j++) {
                output[i*(nums.length)+j]=nums[j];
            }
        }
        return output;
    }
}