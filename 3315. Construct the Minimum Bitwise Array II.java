/*You are given an array nums consisting of n prime integers.
You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
Additionally, you must minimize each value of ans[i] in the resulting array.
If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.*/

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if(n != 2) ans[i] = n - ((n + 1) & (-n - 1)) / 2;
            else ans[i] = -1;
        }  
        return ans;
    }
}
