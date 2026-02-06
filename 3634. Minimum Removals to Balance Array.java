/*You are given an integer array nums and an integer k.
An array is considered balanced if the value of its maximum element is at most k times the minimum element.
You may remove any number of elements from nums​​​​​​​ without making it empty.
Return the minimum number of elements to remove so that the remaining array is balanced.
Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.*/

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            // Use long to prevent integer overflow for nums[i] * k
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return nums.length - maxLen;
    }
}
