//You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
//Return this maximum sum.
//Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ends = new int[n], max_single = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = events[i][1];
            max_single[i] = events[i][2];

            if (i > 0) {
                max_single[i] = Math.max(max_single[i - 1], events[i][2]);
            }
        }

        int ans = max_single[n - 1];

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            int max = Math.max(ans, value);

            int j = binary_search(ends, start, i);

            if (j != -1) {
                ans = Math.max(ans, value + max_single[j]);
            }
        }

        return ans;
    }

    public int binary_search(int[] ends, int target, int right) {
        int left = 0;
        int res = -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ends[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }
}
