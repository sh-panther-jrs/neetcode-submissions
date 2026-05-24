class Solution {
    public int[] countBits(int n) {
       int output[]= new int[n+1];
       if (n==0) {
         return output;   
        }
       output[1] = 1;
       for (int i=2;i<=n;i++) {
        output[i] = output[i>>1] + (i&1);
       }
       return output;
    }
}










