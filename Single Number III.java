//Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
//Find the two elements that appear only once. You can return the answer in any order.
//You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

//Understanding the question:
//XOR 
//0^0=>0
//1^1=>1
//0^1=1
//1^0=>1

//[1,2,1,3,2,5]
//3=>0 1 1
//5=> 1 0 1 
//1 1 0

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int num: nums){
            xor^=num;
        }
        int elWithLowestBitSet = Integer.lowestOneBit(xor);

        int[] ans = new int[2];

        for(int num: nums){
            //Column where the bit is unset
            if((elWithLowestBitSet & num)==0){
                ans[0]^=num;
            }
            else{
                //Column where the bit is set
                ans[1]^=num;
            }
        }
        return ans;
    }
}
