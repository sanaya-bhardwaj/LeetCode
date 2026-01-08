//Given two arrays nums1 and nums2.
//Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
//A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if (m > n) {
            return maxDotProduct(nums2, nums1);
        }
        
        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1000000000); 
        
        for (int i = 1; i <= n; i++) {
            int prev_diag = -1000000000;
            
            for (int j = 1; j <= m; j++) {
                int curr_product = nums1[i-1] * nums2[j-1];
                int temp = dp[j];
                
                int option1 = curr_product;
                int option2 = curr_product + prev_diag;
                int option3 = dp[j];
                int option4 = dp[j-1];
                
                dp[j] = Math.max(Math.max(option1, option2), Math.max(option3, option4));
                
                prev_diag = temp;
            }
        }
        
        return dp[m];
    }
}
