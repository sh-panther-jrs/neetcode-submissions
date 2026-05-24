class Solution {
    public int reverse(int x) {
        int power =0;
        long output = 0;
        while (x!=0) {
            int remainder=x%10;
            output = (output*10) + remainder;
            if (output>Integer.MAX_VALUE || output<Integer.MIN_VALUE) {
                return 0;
            }
            power++;
            x=x/10;
        }
        return (int)output;
    }
}
