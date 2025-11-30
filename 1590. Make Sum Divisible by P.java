//Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
//Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
//A subarray is defined as a contiguous block of elements in the array.

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int target = (int)(total % p);
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long cur = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            cur = (cur + nums[i]) % p;
            int need = (int)((cur - target + p) % p);

            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }

            map.put((int)cur, i);
        }

        return res == nums.length ? -1 : res;
    }
}
