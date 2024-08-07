//You are given an integer array nums consisting of n elements, and an integer k.
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
//Any answer with a calculation error less than 10-5 will be accepted.

//Intuition
//Using memoization.

//Approach
//Two Pointer Approach.

//Complexity
//Time complexity: O(n);

//Space complexity: O(1)

//Code

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double max=0;
        int s=0;
        for(int l=0;l<k;l++){
            s+=nums[l];
        }
        max=(double)s/k;
        int i=0,j=k;
        while(j<n){
            s-=nums[i];
            s+=nums[j];
            max=Math.max(max,(double)s/k);
            i++;
            j++;
        }
        return max;
    }
}

