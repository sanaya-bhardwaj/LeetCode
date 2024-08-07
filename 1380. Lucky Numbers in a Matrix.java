//Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
//A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < matrix[i][row[i]]) {
                    row[i] = j;
                }

                if (matrix[i][j] > matrix[col[j]][j]) {
                    col[j] = i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int j = row[i];
            if (col[j] == i) {
                res.add(matrix[i][j]);
            }
        }

        return res;
    }
}
