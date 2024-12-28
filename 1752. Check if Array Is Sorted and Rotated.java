//Given an array nums, return true if the array was originally sorted in non-decreasing order, 
//then rotated some number of positions (including zero). Otherwise, return false.
//There may be duplicates in the original array.
//Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n=nums.length;

        for (int i = 0; i<n; i++){
            if (nums[i] < nums[(i-1 + n)% n]){
                count++;
            }
            if(count > 1 ){
                return false;
            }
        }
        return true;
    }
}
