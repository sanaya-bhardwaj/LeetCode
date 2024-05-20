//The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
//For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
//Given an array nums, return the sum of all XOR totals for every subset of nums. 
//Note: Subsets with the same elements should be counted multiple times.
//An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

//using dfs

class Solution {
  public int subsetXORSum(int[] nums) {
    return dfs(nums, 0, 0);
  }

  private int dfs(int[] nums, int i, int xors) {
    if (i == nums.length)
      return xors;

    final int x = dfs(nums, i + 1, xors);
    final int y = dfs(nums, i + 1, nums[i] ^ xors);
    return x + y;
  }
}
