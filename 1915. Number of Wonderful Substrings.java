//A wonderful string is a string where at most one letter appears an odd number of times.
//For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
//Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.
//A substring is a contiguous sequence of characters in a string.

class Solution {
  public long wonderfulSubstrings(String word) {
    long ans = 0;
    int prefix = 0;              // the binary prefix
    int[] count = new int[1024]; // the binary prefix count
    count[0] = 1;                // the empty string ""

    for (final char c : word.toCharArray()) {
      prefix ^= 1 << c - 'a';
      // All the letters occur even number of times.
      ans += count[prefix];
      // ('a' + i) occurs odd number of times.
      for (int i = 0; i < 10; ++i)
        ans += count[prefix ^ 1 << i];
      ++count[prefix];
    }

    return ans;
  }
}
