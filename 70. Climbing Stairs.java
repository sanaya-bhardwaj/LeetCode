//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Solution:

class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }

        // Initialize the dynamic programming array
        int[] dp = new int[n + 1];

        // Base cases
        dp[1] = 1;
        dp[2] = 2;

        // Build the dp array using the recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the result for the n-th step
        return dp[n];
    }
}

//This implementation initializes a dynamic programming array and iterates from the 3rd step to the n-th step, filling in the values based on the recurrence relation. 
//The result is the number of distinct ways to climb to the top of the staircase.
