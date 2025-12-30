//A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
//Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
//Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

class Solution {
    public boolean isMagicSquare(int[][] grid, int r, int c) {
        if (grid[r+1][c+1] != 5) return false; //center must always be 5

        int a = grid[r][c],b = grid[r][c+1],d = grid[r][c+2]; // grid ele except centre
        int e = grid[r+1][c],f = grid[r+1][c+2];
        int h = grid[r+2][c],i = grid[r+2][c+1],j = grid[r+2][c+2];

        boolean[] seen = new boolean[10];
        int[] arr = {a,b,d,e,f,h,i,j,5};// 1 - 9 checking
        for (int x : arr) {
            if (x < 1 || x > 9 || seen[x]) return false;
            seen[x] = true;
        }

        if (a + j != 10) return false; //opposite cells must sum to 10
        if (b + i != 10) return false;
        if (d + h != 10) return false;
        if (e + f != 10) return false;

         // Check all rows, columns, and diagonals sum to 15
        if (a + b + d != 15) return false;
        if (h + i + j != 15) return false;
        if (a + e + h != 15) return false;
        if (d + f + j != 15) return false;
        if (a + 5 + j != 15) return false;// centre is 5
        if (d + 5 + h != 15) return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length, c = 0;
        for (int i = 0;i <= m-3;i++) {
            for (int j = 0;j <= n-3;j++) {
                if (isMagicSquare(grid,i,j)) c++;
            }
        }
        return c;
    }
}
