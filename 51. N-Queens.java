//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

class Solution {
    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        for (int i = 0; i < n; i++) { // Vertical check
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { // Upper-left diagonal check
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) { // Upper-right diagonal check
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void solvequeens(int n, List<List<String>> output, char[][] nQueens, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafePlace(n, nQueens, row, col)) {
                nQueens[row][col] = 'Q'; // Place the queen
                solvequeens(n, output, nQueens, row + 1); // Recurse to the next row
                nQueens[row][col] = '.'; // Backtrack by removing the queen
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] nQueens = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.'); // Initialize the chessboard
        }
        
        solvequeens(n, output, nQueens, 0);
        return output;
    }
}
