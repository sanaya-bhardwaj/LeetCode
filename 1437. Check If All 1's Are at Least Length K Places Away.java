//Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        final int n=nums.length;
        int last=-100000000;
        for(int i=0; i<n; i++){
            if (nums[i]==1){
                if (i-last-1<k) return false;
                last=i;
            }
        }
        return true;
        
    }
}
