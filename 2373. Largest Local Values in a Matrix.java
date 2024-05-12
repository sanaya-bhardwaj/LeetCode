//You are given an n x n integer matrix grid.
//Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
//maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
//In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
//Return the generated matrix.

class Solution {
  public int[][] largestLocal(int[][] grid) {
    final int n = grid.length;
    int[][] ans = new int[n - 2][n - 2];

    for (int i = 0; i < n - 2; ++i)
      for (int j = 0; j < n - 2; ++j)
        for (int x = i; x < i + 3; ++x)
          for (int y = j; y < j + 3; ++y)
            ans[i][j] = Math.max(ans[i][j], grid[x][y]);

    return ans;
  }
}
