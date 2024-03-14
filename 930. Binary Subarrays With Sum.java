//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//A subarray is a contiguous part of the array.

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // Initialize with prefix sum 0, count 1

        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            count += prefixSum.getOrDefault(currentSum - goal, 0);
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(Solution.numSubarraysWithSum(nums, goal)); // Output: 4
    }
}
