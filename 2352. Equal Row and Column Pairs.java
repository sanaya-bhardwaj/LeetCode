//Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
//A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, int[]> r = new HashMap<>();
        HashMap<Integer, int[]> c = new HashMap<>();
        for(int i = 0; i < n; i++){
            r.put(i, grid[i]);
        }
        for (int i = 0; i < n; i++) {
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = grid[j][i];
            }
            c.put(i, column);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(Arrays.equals(r.get(i), c.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
}
