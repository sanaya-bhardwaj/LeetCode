//You are given an integer n. There are n rooms numbered from 0 to n - 1.
//You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.
//Meetings are allocated to rooms in the following manner:
//Each meeting will take place in the unused room with the lowest number.
//If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
//When a room becomes unused, meetings that have an earlier original start time should be given the room.
//Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
//A half-closed interval [a, b) is the interval between a and b including a and not including b.

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int[] count = new int[n];
        long[] timer = new long[n];

        int itr = 0;

        while (itr < meetings.length) {
            int[] curr = meetings[itr];
            int start = curr[0];
            int end = curr[1];
            long dur = end - start;

            int room = -1;
            long earliest = Long.MAX_VALUE;
            int earliestRoom = -1;

            for (int i = 0; i < n; i++) {
                if (timer[i] < earliest) {
                    earliest = timer[i];
                    earliestRoom = i;
                }
                if (timer[i] <= start) {
                    room = i;
                    break;
                }
            }

            if (room != -1) {
                timer[room] = end;
                count[room]++;
            } else {
                timer[earliestRoom] += dur;
                count[earliestRoom]++;
            }

            itr++;
        }

        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }

        return idx;
    }
}
