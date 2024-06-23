//Given an array of integers nums and an integer limit, 
//return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Create a TreeMap to keep track of the frequency of each number
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        int maxLength = 0; // Stores the maximum length of the subarray
        int left = 0; // The left pointer for our sliding window

        // Iterate over the array using the right pointer 'right'
        for (int right = 0; right < nums.length; ++right) {
            // Update the frequency of the current number
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

            // Shrink the sliding window until the absolute difference between the max
            // and min within the window is less than or equal to 'limit'
            while (frequencyMap.lastKey() - frequencyMap.firstKey() > limit) {
                // Decrease the frequency of the number at the left pointer
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                // If the frequency drops to zero, remove it from the frequency map
                if (frequencyMap.get(nums[left]) == 0) {
                    frequencyMap.remove(nums[left]);
                }
                // Move the left pointer to the right, shrinking the window
                ++left;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        // Return the maximum length of the subarray that satisfies the condition
        return maxLength;
    }
}
