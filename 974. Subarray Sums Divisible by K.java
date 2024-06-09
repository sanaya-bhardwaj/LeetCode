//Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//A subarray is a contiguous part of an array.

class Solution {
  public int subarraysDivByK(int[] nums, int k) {
    int ans = 0;
    int prefix = 0;
    int[] count = new int[k];
    count[0] = 1;

    for (final int num : nums) {
      prefix = (prefix + num % k + k) % k;
      ans += count[prefix];
      ++count[prefix];
    }

    return ans;
  }
}
