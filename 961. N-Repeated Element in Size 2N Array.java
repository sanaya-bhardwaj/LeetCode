//You are given an integer array nums with the following properties:
//nums.length == 2 * n.
//nums contains n + 1 unique elements.
//Exactly one element of nums is repeated n times.
//Return the element that is repeated n times.

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
            if (i + 2 < n)
                if (nums[i] == nums[i + 2]) return nums[i];
        }
        
        return nums[0];
    }
}
