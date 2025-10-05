//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] pac = new boolean[m][n], atl = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            dfs(A, pac, i, 0); dfs(A, atl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(A, pac, 0, j); dfs(A, atl, m - 1, j);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pac[i][j] && atl[i][j])
                    res.add(List.of(i, j));
        return res;
    }

    void dfs(int[][] A, boolean[][] vis, int i, int j) {
        int m = A.length, n = A[0].length;
        vis[i][j] = true;
        for (int[] d : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && A[x][y] >= A[i][j])
                dfs(A, vis, x, y);
        }
    }
}
