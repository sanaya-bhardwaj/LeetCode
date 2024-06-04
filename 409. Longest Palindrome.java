//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//Letters are case sensitive, for example, "Aa" is not considered a palindrome.

class Solution {
  public int longestPalindrome(String s) {
    int ans = 0;
    int[] count = new int[128];

    for (final char c : s.toCharArray())
      ++count[c];

    for (final int freq : count)
      ans += freq % 2 == 0 ? freq : freq - 1;

    final boolean hasOddCount = Arrays.stream(count).anyMatch(freq -> freq % 2 == 1);
    return ans + (hasOddCount ? 1 : 0);
  }
}
