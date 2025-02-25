//Given an array of integers arr, return the number of subarrays with an odd sum.
//Since the answer can be very large, return it modulo 10`9 + 7.

class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, prefixSum = 0;
        for(int a : arr){
            prefixSum += a;
            oddCount += prefixSum % 2;
        }
        oddCount += (arr.length - oddCount) * oddCount;
        return (int)(oddCount % 1_000_000_007);
    }
}
