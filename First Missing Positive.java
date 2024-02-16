//Given an unsorted integer array nums, return the smallest missing positive integer.

//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

public class Solution {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // First pass: Move each number to its correct position
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Second pass: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers are present, return the next positive integer
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println("Output 1: " + firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Output 2: " + firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Output 3: " + firstMissingPositive(nums3));
    }
}
