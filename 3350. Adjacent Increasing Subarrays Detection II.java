//Given an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. 
//Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return the maximum possible value of k.
//A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), i = 0, res = 0;
        int prev = 0;

        while (i < n) {
            int start = i;

            while (i + 1 < n && nums.get(i) < nums.get(i + 1)) {
                i++;
            }

            int curr = i - start + 1;
            res = Math.max(res, Math.max(curr >> 1, Math.min(curr, prev)));
            
            prev = curr;
            i++;
        }
        
        return res;
    }
}
