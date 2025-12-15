//You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
//A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.
//Return the number of smooth descent periods.

class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1, count = 1;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] == prices[i + 1] + 1) count++;
            else count = 1;
            ans += count;
        }
        return ans;
    }
}
