//A peak element is an element that is strictly greater than its neighbors.
//Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
//You must write an algorithm that runs in O(log n) time.

//Intuition
//A peak element is strictly greater than its neighbors, and our goal is to find one efficiently in O(logn) time. 
//The binary search technique is effective here because if we move in the direction of a larger neighbor, we are guaranteed to approach a peak, given the nature of peaks.



class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;

        for (int i = 1; i < nums.length - 1; i++)
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i])
                return i;

        if (nums[0] > nums[1])
            return 0;

        return nums.length - 1;
    }
}
