//You are given an integer array nums and an integer k. Your task is to partition nums into one or more non-empty contiguous segments such that in each segment, the difference between its maximum and minimum elements is at most k.
//Return the total number of ways to partition nums under this condition.
//Since the answer may be too large, return it modulo 109 + 7.

class Solution {

    static final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n+1];
        int[] prefix = new int[n+2];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();
        int l = 0;

        for(int r=0; r<n; r++) {

            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) maxD.pollLast();

            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) minD.pollLast();

            maxD.addLast(r);
            minD.addLast(r);

            while(nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {

                if(maxD.peekFirst() == l) maxD.pollFirst();
                if(minD.peekFirst() == l) minD.pollFirst();

                l++;
            }

            int prev = (l-1 >= 0) ? prefix[l-1] : 0;

            dp[r+1] = (prefix[r] - prev + MOD) % MOD;
            prefix[r+1] = (prefix[r] + dp[r+1]) % MOD;
        }
        return dp[n];
    }
}
