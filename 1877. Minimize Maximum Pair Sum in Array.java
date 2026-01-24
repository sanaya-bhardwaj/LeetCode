/*The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.
For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
Each element of nums is in exactly one pair, and
The maximum pair sum is minimized.
Return the minimized maximum pair sum after optimally pairing up the elements.*/

class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] freq = new int[100001];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) min = nums[i];
            if(nums[i] > max) max = nums[i];
            freq[nums[i]]++;
        }
        int max_sum = 0, l = min, r = max;
        while(l <= r) {
            if(freq[l] == 0) l++;
            else if(freq[r] == 0) r--;
            else {
                max_sum = Math.max(max_sum, l + r);
                freq[l]--;
                freq[r]--;
            }
        }
        return max_sum;
    }
}
