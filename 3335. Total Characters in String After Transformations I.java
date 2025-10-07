//You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:
//If the character is 'z', replace it with the string "ab".
//Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
//Return the length of the resulting string after exactly t transformations.
//Since the answer may be very large, return it modulo 109 + 7.

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1000000007;
        int[] cnt = new int[26];
        
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int j = 0; j < t; j++) {
            int[] tmp = new int[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) {
                    tmp[0] = (tmp[0] + cnt[i]) % MOD;
                    tmp[1] = (tmp[1] + cnt[i]) % MOD;
                } else {
                    tmp[i + 1] = (tmp[i + 1] + cnt[i]) % MOD;
                }
            }
            cnt = tmp;
        }

        int len = 0;
        for (int c : cnt) {
            len = (len + c) % MOD;
        }

        return len;
    }
}
