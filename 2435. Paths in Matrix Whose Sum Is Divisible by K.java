//You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.
//Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prev = new int[n][k];
        int[][] cur  = new int[n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cur[j], 0);
            }

            for (int j = 0; j < n; j++) {
                int val = grid[i][j] % k;

                if (i == 0 && j == 0) {
                    cur[0][val] = 1;
                    continue;
                }

                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        if (prev[j][r] == 0) continue;
                        int nr = (r + val) % k;
                        cur[j][nr] = (cur[j][nr] + prev[j][r]) % MOD;
                    }
                }

                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        if (cur[j - 1][r] == 0) continue;
                        int nr = (r + val) % k;
                        cur[j][nr] = (cur[j][nr] + cur[j - 1][r]) % MOD;
                    }
                }
            }

            int[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        return prev[n - 1][0];
    }
}
