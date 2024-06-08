//Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
//A good subarray is a subarray where:
//its length is at least two, and
//the sum of the elements of the subarray is a multiple of k.
//Note that:
//A subarray is a contiguous part of the array.
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    int prefix = 0;
    Map<Integer, Integer> prefixToIndex = new HashMap<>();
    prefixToIndex.put(0, -1);

    for (int i = 0; i < nums.length; ++i) {
      prefix += nums[i];
      if (k != 0)
        prefix %= k;
      if (prefixToIndex.containsKey(prefix)) {
        if (i - prefixToIndex.get(prefix) > 1)
          return true;
      } else {
        // Set a new key if it's absent because the previous index is better.
        prefixToIndex.put(prefix, i);
      }
    }

    return false;
  }
}
