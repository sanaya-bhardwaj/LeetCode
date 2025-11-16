//Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

class Solution {
    public int numSub(String s) {
        final int mod=1000000007;
        long cnt=0, ans=0;
        for(char c: s.toCharArray()){
            ans+=((c-'1') & (cnt*(cnt+1)/2));
            cnt=(('0'-c) & (cnt+1));
        }
        ans+=cnt*(cnt+1)/2;// last one
        return (int)(ans%mod);
    }
}
