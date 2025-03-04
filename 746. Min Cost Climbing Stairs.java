//You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
//Once you pay the cost, you can either climb one or two steps.
//You can either start from the step with index 0, or the step with index 1.
//Return the minimum cost to reach the top of the floor.

//Approach : bottom-up approach

//Complexity : Time complexity: O(n)

//Space complexity: O(n)

class Solution {
    public int minCostClimbingStairs(int[]cost){
        int [] dp=new int[cost.length];
        dp[0] = cost[0];
        dp[1]=cost[1];
        for (int i=2; i<cost.length; i++){
            int s = dp[i-1];
            int f= dp[i-2];
            dp[i] = Math.min(s,f)+ cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
