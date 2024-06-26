//You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
//Return the score of s.

class Solution {
  public int scoreOfString(String s) {
    int ans = 0;

    for (int i = 1; i < s.length(); ++i)
      ans += Math.abs(s.charAt(i) - s.charAt(i - 1));

    return ans;
  }
}
