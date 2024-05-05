//Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
//Return the positive integer k. If there is no such integer, return -1.

public class Solution {
  public int findMaxK(int[] nums) {
    int ans = -1;
    Set<Integer> seen = new HashSet<>();

    for (final int num : nums)
      if (seen.contains(-num))
        ans = Math.max(ans, Math.abs(num));
      else
        seen.add(num);

    return ans;
  }
}