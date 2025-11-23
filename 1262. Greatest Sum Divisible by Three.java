//Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        
        for (int num : nums) {
            int[] current = dp.clone();
            
            for (int sum : current) {
                int newSum = sum + num;
                int remainder = newSum % 3;
                dp[remainder] = Math.max(dp[remainder], newSum);
            }
        }
        
        return dp[0];
    }
}
