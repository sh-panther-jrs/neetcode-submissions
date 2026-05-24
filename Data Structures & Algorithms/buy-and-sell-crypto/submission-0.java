class Solution {
    public int maxProfit(int[] prices) {
        int maxPriceRight=prices[prices.length-1];
        int index=prices.length-2;
        int maxProfit=0;
        while(index>=0) {
            if (maxPriceRight-prices[index]>maxProfit) {
                maxProfit = maxPriceRight-prices[index];
            }
            if (maxPriceRight<prices[index]) {
                maxPriceRight=prices[index];
            }
            index--;
        }
        return maxProfit;
    }
}
