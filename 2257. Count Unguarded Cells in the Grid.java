//You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
//A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
//Return the number of unoccupied cells that are not guarded.

class Solution 
{
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) 
    {

        // Step 1: Initialize the grid
        // 0 → unguarded, 1 → guarded, 2 → occupied (guard or wall)
        int[][] grid = new int[m][n];

        // Step 2: Mark guards and walls on the grid
        for (int[] g : guards)
        {
            grid[g[0]][g[1]] = 2;
        } 
        for (int[] w : walls)
        {
            grid[w[0]][w[1]] = 2;
        } 

        // Step 3: Define directions (up, right, down, left)
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 4: Simulate guard vision (ray propagation)
        for (int[] g : guards) 
        {
            int gr = g[0], gc = g[1];
            for (int d = 0; d < 4; d++) 
            {
                int r = gr + dr[d], c = gc + dc[d];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] < 2) 
                {
                    grid[r][c] = 1; // mark as guarded
                    r += dr[d];
                    c += dc[d];
                }
            }
        }

        // Step 5: Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 0) count++;
            }
        }

        // Step 6: Return the result
        return count;
    }
}
