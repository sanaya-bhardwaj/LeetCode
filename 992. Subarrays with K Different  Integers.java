//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//A good array is an array where the number of different integers in that array is exactly k.
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.

//Solution:

class Solution {
  public int subarraysWithKDistinct(int[] nums, int k) {
    return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
  }

  private int subarraysWithAtMostKDistinct(int[] nums, int k) {
    int ans = 0;
    int[] count = new int[nums.length + 1];

    for (int l = 0, r = 0; r < nums.length; ++r) {
      if (++count[nums[r]] == 1)
        --k;
      while (k == -1)
        if (--count[nums[l++]] == 0)
          ++k;
      ans += r - l + 1; // nums[l..r], nums[l + 1..r], ..., nums[r]
    }

    return ans;
  }
}
