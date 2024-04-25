//You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:
//t is a subsequence of the string s.
//The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
//Return the length of the longest ideal string.
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
//Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.

class Solution {
  public int longestIdealString(String s, int k) {
    // dp[i] := the longest subsequence that ends in ('a' + i)
    int[] dp = new int[26];

    for (final char c : s.toCharArray()) {
      final int i = c - 'a';
      dp[i] = 1 + getMaxReachable(dp, i, k);
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  private int getMaxReachable(int[] dp, int i, int k) {
    final int first = Math.max(0, i - k);
    final int last = Math.min(25, i + k);
    int maxReachable = 0;
    for (int j = first; j <= last; ++j)
      maxReachable = Math.max(maxReachable, dp[j]);
    return maxReachable;
  }
}
