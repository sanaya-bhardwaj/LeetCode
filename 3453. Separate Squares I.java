/*You are given a 2D integer array squares. Each squares[i] = [xi, yi, li] represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.
Find the minimum y-coordinate value of a horizontal line such that the total area of the squares above the line equals the total area of the squares below the line.
Answers within 10-5 of the actual answer will be accepted.
Note: Squares may overlap. Overlapping areas should be counted multiple times.*/

class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = 1e18, high = -1e18;

        for (int[] s : squares) {
            double y = s[1], l = s[2];
            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        for (int i = 0; i < 80; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] s : squares) {
                double y = s[1], l = s[2];
                if (mid <= y) continue;
                if (mid >= y + l) areaBelow += l * l;
                else areaBelow += l * (mid - y);
            }

            if (areaBelow * 2 < totalArea)
                low = mid;
            else
                high = mid;
        }
        return low;
    }
}
