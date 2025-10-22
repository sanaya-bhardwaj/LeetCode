//You are given an integer array nums and two integers k and numOperations.
//You must perform an operation numOperations times on nums, where in each operation you:
//Select an index i that was not selected in any previous operations.
//Add an integer in the range [-k, k] to nums[i].
//Return the maximum possible frequency of any element in nums after performing the operations.

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int right = 0;
        int sumCount = 0;
        int result = 0;
        int left2 = 0;
        int sumCount2 = 0;
        int count = 0;
        int prev = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == prev) {
                count++;
            } else {
                prev = num;
                count = 1;
            }

            while (nums[left] < num - k) {
                sumCount--;
                left++;
            }

            while (right < n && nums[right] <= num + k) {
                sumCount++;
                right++;
            }
            result = Math.max(result, count + Math.min(sumCount - count, numOperations));

            sumCount2++;
            while (nums[left2] < num - 2L * k) {
                sumCount2--;
                left2++;
            }
            result = Math.max(result, Math.min(sumCount2, numOperations));
        }

        return result;
    }
}
