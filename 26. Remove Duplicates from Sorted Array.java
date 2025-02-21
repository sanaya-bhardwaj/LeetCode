//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
//The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. 
//The remaining elements of nums are not important as well as the size of nums.
//Return k.


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // If the array is empty, there are no duplicates
        }

        int k = 1; // Initialize the count of unique elements

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Move the unique element to the next position
                k++; // Increment the count of unique elements
            }
        }

        return k; // Return the count of unique elements
    }
}

//This code uses two pointers (i and k) to iterate through the array. 
//The variable k keeps track of the position where the next unique element should be placed. 
//If the current element is different from the previous one, it means it's a new unique element, so it's moved to the next position in the array, and k is incremented. 
//Finally, the value of k represents the number of unique elements in the modified array.
