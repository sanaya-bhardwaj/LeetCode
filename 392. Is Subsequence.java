//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
//(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

//Algorithm Overview:

//Initialize two pointers, sp and tp, to 0 to represent the starting positions of the strings s and t respectively.
//Iterate through the characters of both strings s and t, comparing characters at the corresponding positions.
//If a matching character is found, move the pointer in s forward.
//Always move the pointer in t forward.
//Check if all characters in s have been matched in t.
//Return True if s is a subsequence of t, False otherwise.

//Detailed Explanation:
//Set sp and tp to 0, indicating the starting positions of s and t respectively.
//Iterate through the characters of s and t using a while loop until either all characters in s have been matched or we reach the end of t.
//a. Check if the characters at sp in s and tp in t are equal.
//b. If they are equal, increment sp to move to the next character in s.
//c. Always increment tp to move forward in t.
//After the loop, check if all characters in s have been matched. If sp is equal to the length of s, then s is a subsequence of t.
//a. Return True if s is a subsequence of t.
//b. Return False if s is not a subsequence of t.

//Complexity
//Time complexity: O(n)
//n is longer length of input string (s or t).
//Space complexity: O(1)

//CODE

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();        
    }
}
