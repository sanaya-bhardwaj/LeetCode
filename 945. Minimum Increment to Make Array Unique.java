//You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
//Return the minimum number of moves to make every value in nums unique.
//The test cases are generated so that the answer fits in a 32-bit integer.

class Solution {
  public int minIncrementForUnique(int[] nums) {
    int ans = 0;
    int minAvailable = 0;

    Arrays.sort(nums);

    for (final int num : nums) {
      ans += Math.max(minAvailable - num, 0);
      minAvailable = Math.max(minAvailable, num) + 1;
    }

    return ans;
  }
}
