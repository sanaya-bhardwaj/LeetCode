//You are given an integer array nums and an integer k.
//The frequency of an element x is the number of times it occurs in an array.
//An array is called good if the frequency of each element in this array is less than or equal to k.
//Return the length of the longest good subarray of nums.
//A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
  public int maxSubarrayLength(int[] nums, int k) {
    int ans = 0;
    Map<Integer, Integer> count = new HashMap<>();

    for (int l = 0, r = 0; r < nums.length; ++r) {
      count.merge(nums[r], 1, Integer::sum);
      while (count.get(nums[r]) == k + 1)
        count.merge(nums[l++], -1, Integer::sum);
      ans = Math.max(ans, r - l + 1);
    }

    return ans;
  }
}
