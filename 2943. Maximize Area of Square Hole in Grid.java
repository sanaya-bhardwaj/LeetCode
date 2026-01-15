/*You are given the two integers, n and m and two integer arrays, hBars and vBars. The grid has n + 2 horizontal and m + 2 vertical bars, creating 1 x 1 unit cells. The bars are indexed starting from 1.
You can remove some of the bars in hBars from horizontal bars and some of the bars in vBars from vertical bars. Note that other bars are fixed and cannot be removed.
Return an integer denoting the maximum area of a square-shaped hole in the grid, after removing some bars (possibly none).*/

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxConsecutiveHBars = 1;
        int maxConsecutiveVBars = 1;

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hLength = hBars.length;
        int vLength = vBars.length;

        int tempH = 1;
        int tempV = 1;

        for (int i = 1; i < Math.max(hLength, vLength); i++) {

            if (i < hLength && hBars[i] - hBars[i - 1] == 1) {
                tempH++;
            } else if (i < hLength) {
                maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
                tempH = 1;
            }

            if (i < vLength && vBars[i] - vBars[i - 1] == 1) {
                tempV++;
            } else if (i < vLength) {
                maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);
                tempV = 1;
            }
        }

        maxConsecutiveHBars = Math.max(maxConsecutiveHBars, tempH);
        maxConsecutiveVBars = Math.max(maxConsecutiveVBars, tempV);

        int squareLen = Math.min(maxConsecutiveHBars, maxConsecutiveVBars) + 1;

        return squareLen * squareLen;
    }
}
