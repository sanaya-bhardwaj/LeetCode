//You are given an array of binary strings strs and two integers m and n.
//Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
//A set x is a subset of a set y if all elements of x are also elements of y.

class Solution {
    public int findMaxForm(String[] S, int M, int N) {
        int[][] dp = new int[M+1][N+1];
        for (String str : S) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray())
                if (c == '0') zeros++;
                else ones++;
            for (int i = M; i >= zeros; i--)
                for (int j = N; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
        }
        return dp[M][N];
    }
}
