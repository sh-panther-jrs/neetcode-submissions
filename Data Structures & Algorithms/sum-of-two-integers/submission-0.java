class Solution {
    public int getSum(int a, int b) {

       int sumWithoutCarry = a^b;
       int carry = (a&b) <<1;
       while(carry!=0) {
        int temp = sumWithoutCarry;
        sumWithoutCarry=sumWithoutCarry^carry;
        carry = (carry&temp) <<1;
       }
       return sumWithoutCarry;
    }
}
