//Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
//A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

class Solution {
  public int minFallingPathSum(int[][] grid) {
    final int n = grid.length;

    for (int i = 1; i < n; ++i) {
      Pair<Integer, Integer>[] twoMinnumAndIndexes = getTwoMinnumAndIndexes(grid[i - 1]);
      final int firstMinNum = twoMinnumAndIndexes[0].getKey();
      final int firstMinIndex = twoMinnumAndIndexes[0].getValue();
      final int secondMinNum = twoMinnumAndIndexes[1].getKey();
      for (int j = 0; j < n; ++j)
        if (j == firstMinIndex)
          grid[i][j] += secondMinNum;
        else
          grid[i][j] += firstMinNum;
    }

    return Arrays.stream(grid[n - 1]).min().getAsInt();
  }

  private Pair<Integer, Integer>[] getTwoMinnumAndIndexes(int[] A) {
    List<Pair<Integer, Integer>> numAndIndexes = new ArrayList<>();

    for (int i = 0; i < A.length; ++i)
      numAndIndexes.add(new Pair<>(A[i], i));

    Collections.sort(numAndIndexes, (a, b) -> a.getKey() - b.getKey());
    return new Pair[] {numAndIndexes.get(0), numAndIndexes.get(1)};
  }
}
