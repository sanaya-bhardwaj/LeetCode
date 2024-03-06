//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. 
//If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.

//SOLUTION:

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = solution.search(nums, target);

        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}


//The search method in the Solution class implements a binary search algorithm to find the index of a target element in a sorted array. 
//It maintains two pointers, left and right, narrowing down the search space in each iteration until the target is found or the search space is empty. 
//If the target is found, the method returns its index; otherwise, it returns -1. 
//The example usage in the main method demonstrates how to use this function with a sample array and target value.
