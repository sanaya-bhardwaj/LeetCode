//Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
//Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while(c > 0 || b > 0 || a > 0) {
            int cBit = (c & 1);
            int aBit = (a & 1);
            int bBit = (b & 1);
        
            if(cBit == 1) {
                if(aBit == 0 && bBit == 0) {
                    ans++;
                }
            } else {
                ans += aBit + bBit;
            }
            a >>= 1; b >>= 1; c >>= 1;
        }

        return ans;
    }
}
