//There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
//Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
//You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
//Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        DSU dsu = new DSU(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int i = 0; i < row * col; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;

            int id1 = r * col + c + 1;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                    dsu.union(id1, nr * col + nc + 1);
                }
            }

            if (c == 0)
                dsu.union(0, id1);
            if (c == col - 1)
                dsu.union(row * col + 1, id1);

            if (dsu.find(0) == dsu.find(row * col + 1))
                return i;
        }

        return -1;
    }
}

class DSU {
    int[] root, size;

    public DSU(int n) {
        root = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        Arrays.fill(size, 1);
    }

    public int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry)
            return;

        if (size[rx] > size[ry]) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }

        root[rx] = ry;
        size[ry] += size[rx];
    }
}
