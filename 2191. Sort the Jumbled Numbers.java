//You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.
//The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9.
//You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on the mapped values of its elements.
//Notes:
//Elements with the same mapped values should appear in the same relative order as in the input.
//The elements of nums should only be sorted based on their mapped values and not be replaced by them.

class Solution {
    private int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        int n = nums.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {f(nums[i]), i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[arr[i][1]];
        }
        return ans;
    }

    private int f(int x) {
        if (x == 0) {
            return mapping[0];
        }
        int y = 0;
        for (int k = 1; x > 0; x /= 10) {
            int v = mapping[x % 10];
            y = k * v + y;
            k *= 10;
        }
        return y;
    }
}
