//You are given two integer arrays prices and strategy, where:
//prices[i] is the price of a given stock on the ith day.
//strategy[i] represents a trading action on the ith day, where:
//-1 indicates buying one unit of the stock.
//0 indicates holding the stock.
//1 indicates selling one unit of the stock.
//You are also given an even integer k, and may perform at most one modification to strategy. A modification consists of:
//Selecting exactly k consecutive elements in strategy.
//Set the first k / 2 elements to 0 (hold).
//Set the last k / 2 elements to 1 (sell).
//The profit is defined as the sum of strategy[i] * prices[i] across all days.
//Return the maximum possible profit you can achieve.
//Note: There are no constraints on budget or stock ownership, so all buy and sell operations are feasible regardless of past actions.

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length, h = k >> 1;
        long base = 0, prev = 0, nxt = 0, best = 0;

        for (int i = 0; i < n; i++) base += (long) strategy[i] * prices[i];

        for (int i = 0; i < k; i++) {
            prev += (long) strategy[i] * prices[i];
            if (i >= h) nxt += prices[i];
        }

        best = Math.max(0, nxt - prev);

        for (int r = k; r < n; r++) {
            int l = r - k + 1;
            prev += (long) strategy[r] * prices[r]
                 - (long) strategy[l - 1] * prices[l - 1];
            nxt += prices[r] - prices[l - 1 + h];
            best = Math.max(best, nxt - prev);
        }

        return base + best;
    }
}
