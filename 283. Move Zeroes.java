//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.


class Solution {
    public void moveZeroes(int[] nums) {
     int a=0;
     for(int i=0;i<nums.length;i++){
        if(nums[i]!=0){
            nums[a]=nums[i];
            a++;
        } 
     }
     for(int i=a;i<nums.length;i++){
        nums[i]=0;
     }
    }
}
