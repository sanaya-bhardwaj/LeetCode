//On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
//You can move according to these rules:
//In 1 second, you can either:
//move vertically by one unit,
//move horizontally by one unit, or
//move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
//You have to visit the points in the same order as they appear in the array.
//You are allowed to pass through points that appear later in the order, but these do not count as visits.

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        
        for(int i = 1; i < points.length; i++){
            int x2 = points[i][0];
            int x1 = points[i-1][0];

            int y2 = points[i][1];
            int y1 = points[i-1][1];

            ans += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
        return ans;
    }
}
