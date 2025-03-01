//You are given a 0-indexed array nums of size n consisting of non-negative integers.
//You need to apply n - 1 operations to this array where, in the ith operation (0-indexed), you will apply the following on the ith element of nums:
//If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0's to the end of the array.

For example, the array [1,0,2,0,0,1] after shifting all its 0's to the end, is [1,2,1,0,0,0].
Return the resulting array.

Note that the operations are applied sequentially, not all at once.

  class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Shift zeros to the end (in-place)
        int nonZeroIdx = 0;
        
        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIdx++] = nums[i];
            }
        }
        
        // Fill the remaining positions with zeros
        while (nonZeroIdx < n) {
            nums[nonZeroIdx++] = 0;
        }
        
        return nums;
    }
}
