class Solution {
    public int reverseBits(int n) {
        int output =0;
        int index =0;
        while(index<32) {
            output=output<<1;
            output= output | ((n>>index)&1);
            index++;
        }
        return output;
    }
}
