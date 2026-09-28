class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxProfit = 0, buyIdx = 0, sellIdx = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            if (prices[i - 1] < prices[i]) {
                sellIdx = i;
            } else {
                if (prices[i] < prices[buyIdx]) {
                    buyIdx = i;
                }
            }
            if (buyIdx < sellIdx) {
                maxProfit = Math.max(maxProfit, prices[sellIdx] - prices[buyIdx]);
            }
        }
        return maxProfit;        
    }
}
