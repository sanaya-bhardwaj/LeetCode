//Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. 
//Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return true if it is possible to find two such subarrays, and false otherwise.

public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int inc = 1, prevInc = 0, maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc++;
            else {
                prevInc = inc;
                inc = 1;
            }
            maxLen = Math.max(maxLen, Math.max(inc >> 1, Math.min(prevInc, inc)));
            if (maxLen >= k) return true;
        }
        return false;
    }
}
