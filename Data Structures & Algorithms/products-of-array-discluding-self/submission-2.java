class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totProd=1;
        int[] output = new int[nums.length];
        int zeroCount=0;
        for (int num: nums) {
            if (num==0) {
                zeroCount++;
                continue;
            }
            totProd=totProd*num;
        }
        if (zeroCount>1) {
            return output;
        }
        for (int i=0;i<nums.length; i++) {
            if (zeroCount>0) {
                if (nums[i]==0) {
                    output[i]=totProd;
                } 
            }
            else {
                output[i] = totProd/nums[i];
            } 
        }
        return output;
    }
}  
