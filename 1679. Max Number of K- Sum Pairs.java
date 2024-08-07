//You are given an integer array nums and an integer k.
//In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
//Return the maximum number of operations you can perform on the array.

class Solution {
    public int maxOperations(int[] nums, int k) {
        int ops=0;
        int i=0; 
        int j= nums.length-1;
        Arrays.sort(nums);
        while(i<j){
            if(nums[i]+nums[j]==k){
                ops++;
                i++; j--;
            } else if(nums[i]+nums[j]>k){
                j--;
            } else{
                i++;
            }
        }
        return ops;
    }
}
