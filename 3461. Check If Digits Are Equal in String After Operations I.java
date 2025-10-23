//You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:
//For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
//Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
//Return true if the final two digits in s are the same; otherwise, return false.

class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder t = new StringBuilder();
            for (int i = 0; i + 1 < s.length(); i++) {
                t.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
            }
            s = t.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
