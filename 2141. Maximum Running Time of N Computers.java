//You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.
//Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.
//Note that the batteries cannot be recharged.
//Return the maximum number of minutes you can run all the n computers simultaneously.

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;

        while (left < right) {
            long mid = (left + right + 1) >> 1;
            long need = mid * n, have = 0;

            for (int b : batteries) 
                have += Math.min(b, mid);

            if (have >= need) left = mid;
            else right = mid - 1;
        }

        return left;
    }
}
