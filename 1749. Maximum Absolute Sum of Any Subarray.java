//You are given an integer array nums. 
//The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
//Return the maximum absolute sum of any (possibly empty) subarray of nums.
//Note that abs(x) is defined as follows:
//If x is a negative integer, then abs(x) = -x.
//If x is a non-negative integer, then abs(x) = x.

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        
        // Kadane's algorithm to find max and min subarray sums
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        
        // The maximum absolute sum is the maximum of the absolute values of maxSoFar and minSoFar
        return Math.max(Math.abs(maxSoFar), Math.abs(minSoFar));
    }
}
