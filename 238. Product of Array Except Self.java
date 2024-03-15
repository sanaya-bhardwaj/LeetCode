//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//You must write an algorithm that runs in O(n) time and without using the division operation.

//SOLUTION:

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // Initialize arrays to store prefix and suffix products
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        
        // Initialize answer array
        int[] answer = new int[n];
        
        // Calculate prefix products
        prefixProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }
        
        // Calculate suffix products
        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }
        
        // Calculate answer array by multiplying prefix and suffix products
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct[i] * suffixProduct[i];
        }
        
        return answer;
    }
}
