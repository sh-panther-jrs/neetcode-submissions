class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amt = new int[amount+1];
        Arrays.fill(amt, Integer.MAX_VALUE);
        amt[0] = 0;
        for(int i=1; i<=amount;i++) {
            for(int coin: coins) {
                if(i-coin>=0 && amt[i-coin]!=Integer.MAX_VALUE){
                    amt[i] = Math.min(amt[i], amt[i-coin]+1);
                }
            }
        }
        return amt[amount]==Integer.MAX_VALUE?-1:amt[amount];
    }
}
