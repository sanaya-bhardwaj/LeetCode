//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return the number of distinct solutions to the n-queens puzzle.

class Solution {
    public int totalNQueens(int n) {       
        boolean[] column = new boolean[n];
        boolean[] topLeftToBottomRightDiagonal = new boolean[2 * n - 1];
        boolean[] topRightToBottomLeftDiagonal = new boolean[2 * n - 1];
        return backtrack(0, n, column, topLeftToBottomRightDiagonal, topRightToBottomLeftDiagonal);
    }

    int backtrack(int row, int n, boolean[] column, boolean[] TLtoBR, boolean[] TRtoBL) {
        if (row == n)
            return 1;
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (column[col] || TLtoBR[row - col + (n - 1)] || TRtoBL[row + col])
                continue;
            else {
                // place queen
                column[col] = TLtoBR[row - col + (n - 1)] = TRtoBL[row + col] = true;
                // try next row
                count += backtrack(row + 1, n, column, TLtoBR, TRtoBL);  
                // remove queen
                column[col] = TLtoBR[row - col + (n - 1)] = TRtoBL[row + col] = false;
            }
        }

        return count;
    }
}
