//Write a program to solve a Sudoku puzzle by filling the empty cells.

//A sudoku solution must satisfy all of the following rules:

//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.


class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true; // Found a solution
                            }

                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Board is filled, solution found
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check if 'num' is not already in the same row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check if 'num' is not already in the same 3x3 sub-box
        int subBoxStartRow = 3 * (row / 3);
        int subBoxStartCol = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subBoxStartRow + i][subBoxStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
