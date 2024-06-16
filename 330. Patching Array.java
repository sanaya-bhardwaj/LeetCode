//Given a sorted integer array nums and an integer n, 
//add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
//Return the minimum number of patches required.


class Solution {
  public int minPatches(int[] nums, int n) {
    int ans = 0;
    int i = 0;     // nums' index
    long miss = 1; // the minimum sum in [1, n] we might miss

    while (miss <= n)
      if (i < nums.length && nums[i] <= miss) {
        miss += nums[i++];
      } else {
        // Greedily add `miss` itself to increase the range from
        // [1, miss) to [1, 2 * miss).
        miss += miss;
        ++ans;
      }

    return ans;
  }
}
