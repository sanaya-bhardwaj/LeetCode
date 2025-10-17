//You are given a string s and an integer k.
//First, you are allowed to change at most one index in s to another lowercase English letter.
//After that, do the following partitioning operation until s is empty:
//Choose the longest prefix of s containing at most k distinct characters.
//Delete the prefix from s and increase the number of partitions by one. The remaining characters (if any) in s maintain their initial order.
//Return an integer denoting the maximum number of resulting partitions after the operations by optimally choosing at most one index to change.

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        if (k == 26) return 1;
        
        int n = s.length();
        int[] leftMask = new int[n];
        int[] leftDup = new int[n];
        int[] leftParts = new int[n];
        
        int mask = 0, dup = 0, parts = 1;
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            dup |= mask & bit;
            mask |= bit;
            if (Integer.bitCount(mask) > k) {
                mask = bit;
                dup = 0;
                parts++;
            }
            leftMask[i] = mask;
            leftDup[i] = dup;
            leftParts[i] = parts;
        }
        
        int result = parts;
        mask = 0;
        dup = 0;
        parts = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            int bit = 1 << (s.charAt(i) - 'a');
            dup |= mask & bit;
            mask |= bit;
            
            int bitCount = Integer.bitCount(mask);
            if (bitCount > k) {
                mask = bit;
                dup = 0;
                parts++;
            }
            
            if (bitCount == k) {
                if (((bit & dup) != 0) && 
                    ((bit & leftDup[i]) != 0) && 
                    (Integer.bitCount(leftMask[i]) == k) && 
                    ((leftMask[i] | mask) != 0x3FFFFFF)) {
                    result = Math.max(result, parts + leftParts[i] + 2);
                } else if (dup != 0) {
                    result = Math.max(result, parts + leftParts[i] + 1);
                }
            }
        }
        
        return result;
    }
}
