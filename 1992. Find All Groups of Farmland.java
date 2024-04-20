//You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1 represents a hectare of farmland.
//To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland. These rectangular areas are called groups. 
//No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
//land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right corner of land is (m-1, n-1). 
//Find the coordinates of the top left and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
//Return a 2D array containing the 4-length arrays described above for each group of farmland in land. 
//If there are no groups of farmland, return an empty array. You may return the answer in any order.


class Solution {
  public int[][] findFarmland(int[][] land) {
    List<int[]> ans = new ArrayList<>();

    for (int i = 0; i < land.length; ++i)
      for (int j = 0; j < land[0].length; ++j)
        if (land[i][j] == 1) {
          int[] cell = new int[] {i, j};
          dfs(land, i, j, cell);
          ans.add(new int[] {i, j, cell[0], cell[1]});
        }

    return ans.stream().toArray(int[][] ::new);
  }

  private void dfs(int[][] land, int i, int j, int[] cell) {
    if (i < 0 || i == land.length || j < 0 || j == land[0].length)
      return;
    if (land[i][j] != 1)
      return;
    land[i][j] = 2; // Mark as visited.
    cell[0] = Math.max(cell[0], i);
    cell[1] = Math.max(cell[1], j);
    dfs(land, i + 1, j, cell);
    dfs(land, i, j + 1, cell);
  }
}
