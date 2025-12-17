//You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.
//You are allowed to make at most k transactions, where each transaction can be either of the following:
//Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].
//Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].
//Note that you must complete each transaction before starting another. Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.
//Return the maximum total profit you can earn by making at most k transactions.

class Solution {
    class State {
        long maxProfit, buyHold, sellHold;
        State(long p, long b, long s) {
            maxProfit = p;
            buyHold = b;
            sellHold = s;
        }
    }
    
    public long maximumProfit(int[] prices, int k) {
        int firstPrice = prices[0];
        State[] dp = new State[k + 1];
        for (int idx = 0; idx <= k; idx++) {
            dp[idx] = new State(0, -firstPrice, firstPrice);
        }
        int n = prices.length;
        
        for (int day = 1; day < n; day++) {
            int currPrice = prices[day];
            for (int trans = k; trans > 0; trans--) {
                long prevProfit = dp[trans - 1].maxProfit;
                dp[trans].maxProfit = Math.max(dp[trans].maxProfit, Math.max(dp[trans].buyHold + currPrice, dp[trans].sellHold - currPrice));
                dp[trans].buyHold = Math.max(dp[trans].buyHold, prevProfit - currPrice);
                dp[trans].sellHold = Math.max(dp[trans].sellHold, prevProfit + currPrice);
            }
        }
        
        return dp[k].maxProfit;
    }
}
