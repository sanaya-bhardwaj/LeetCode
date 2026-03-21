/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.*/

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}


class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
}
