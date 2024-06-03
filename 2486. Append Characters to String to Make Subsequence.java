//You are given two strings s and t consisting of only lowercase English letters.
//Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

class Solution {
  public int appendCharacters(String s, String t) {
    int i = 0; // t's index

    for (final char c : s.toCharArray())
      if (c == t.charAt(i))
        if (++i == t.length())
          return 0;

    return t.length() - i;
  }
}
