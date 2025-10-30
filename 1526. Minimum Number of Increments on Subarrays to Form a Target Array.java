//You are given an integer array target. You have an integer array initial of the same size as target with all elements initially zeros.
//In one operation you can choose any subarray from initial and increment each value by one.
//Return the minimum number of operations to form a target array from initial.
//The test cases are generated so that the answer fits in a 32-bit integer.

class Solution {
    public int minNumberOperations(int[] target) {
        final int n=target.length;
        int ans=target[0];
        for(int i=1; i<n; i++)
            ans+=Math.max(target[i]-target[i-1], 0);
        return ans;
    }
}
