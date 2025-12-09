//You are given an integer array nums.
//A special triplet is defined as a triplet of indices (i, j, k) such that:
//0 <= i < j < k < n, where n = nums.length
//nums[i] == nums[j] * 2
//nums[k] == nums[j] * 2
//Return the total number of special triplets in the array.
//Since the answer may be large, return it modulo 109 + 7.

class Solution {
    final static int mod=(int)1e9+7, M=(int)1e5+1;
    public int specialTriplets(int[] nums) {
        final int  n=nums.length;
        int [] freq=new int[M];
        int [] prev=new int[M];
        for(int x: nums) freq[x]++;
        long cnt=0;
        prev[nums[0]]++;
        for(int i=1; i<n-1; i++){
            final int x=nums[i], x2=x<<1;
            if (x2<M)
                cnt+=(long)prev[x2]*(freq[x2]-prev[x2]-(x==0?1:0));
            prev[x]++;
        }
        return (int)(cnt%mod);
    }
}
