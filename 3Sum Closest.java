//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//Return the sum of the three integers.
//You may assume that each input would have exactly one solution.

 
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest_sum = Integer.MAX_VALUE / 2;  // A large value but not overflow
        
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    int current_sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(current_sum - target) < Math.abs(closest_sum - target)) {
                        closest_sum = current_sum;
                    }
                }
            }
        }
        
        return closest_sum;
    }
}
