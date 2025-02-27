//A sequence x1, x2, ..., xn is Fibonacci-like if:
//n >= 3
//xi + xi+1 == xi+2 for all i + 2 <= n
//Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. 
//If one does not exist, return 0.
//A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. 
//For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;
        
        for (int curr = 2; curr < n; curr++) {
            int start = 0, end = curr - 1;
            while (start < end) {
                int pairSum = arr[start] + arr[end];
                if (pairSum > arr[curr]) {
                    end--;
                } else if (pairSum < arr[curr]) {
                    start++;
                } else {
                    dp[end][curr] = dp[start][end] + 1;
                    maxLen = Math.max(dp[end][curr], maxLen);
                    end--;
                    start++;
                }
            }
        }
        return maxLen == 0 ? 0 : maxLen + 2;
    }
}
