//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
//The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//Change the array nums such that the first k elements of nums contain the elements which are not equal to val. 
//The remaining elements of nums are not important as well as the size of nums.
//Return k.

//SOLUTION:

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Initialize a pointer for the non-equal elements

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j]; // Move the non-equal element to the front
                i++; // Increment the pointer for non-equal elements
            }
        }

        return i; // Return the count of elements not equal to val
    }
}

//Explanation:

//The code uses two pointers, i and j, where i represents the index for the non-equal elements, and j iterates through the entire array.
//If nums[j] is not equal to val, it means it's a non-equal element, so it is moved to the front of the array at index i. The pointers are then incremented.
//The loop continues until all elements are processed, and i represents the count of elements not equal to val.
//The modified array is not explicitly returned, but the function returns the count i, which represents the number of elements in nums that are not equal to val.
//This solution follows the in-place modification requirement and efficiently solves the problem
