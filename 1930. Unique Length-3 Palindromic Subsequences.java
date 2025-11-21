//Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//A palindrome is a string that reads the same forwards and backwards.
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//For example, "ace" is a subsequence of "abcde".

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int char_index = s.charAt(i) - 'a';
            if (first[char_index] == -1) {
                first[char_index] = i;
            }
            last[char_index] = i;
        }
        
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && first[i] < last[i]) {
                boolean[] seen = new boolean[26];
                for (int j = first[i] + 1; j < last[i]; j++) {
                    int middle_char = s.charAt(j) - 'a';
                    if (!seen[middle_char]) {
                        seen[middle_char] = true;
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
}
