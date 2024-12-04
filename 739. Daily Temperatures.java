//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int i=1; i<points.length; i++){
            if (points[i][0] > currentEnd){
                arrows++;
                currentEnd = points[i][1];
            }
        }
        return arrows;
    }
}
