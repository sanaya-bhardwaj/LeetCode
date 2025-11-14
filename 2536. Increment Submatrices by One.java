//You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
//You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
//Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.
//Return the matrix mat after performing every query.

class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];
        
        for(int[] q : queries){// diff array
            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];

            for(int i=row1;i<=row2;i++){
                diff[i][col1] += 1;
                if(col2+1 < n) diff[i][col2+1] -= 1;
            }
        }
        for(int i=0;i<n;i++){ // prefix sum row wise
            for(int j=1;j<n;j++){
                diff[i][j] += diff[i][j-1];
            }
        }

        return diff;
    }
}
