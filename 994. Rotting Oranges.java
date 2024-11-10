//You are given an m x n grid where each cell can have one of three values:

//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


//Approach for this Problem:
//Create a visited grid to store the state of the cell (fresh, rotten, or empty).
//Initialize a queue to store the rotten oranges and count the number of fresh oranges.
//Check if there are no fresh oranges, return 0, or if there are no rotten oranges, return -1.
//Loop while the queue is not empty.
//a. Store the size of the queue.
//b. Loop through the size of the queue.
//i. Get the front cell of the queue.
//ii. Check all four directions of the cell to see if there are any fresh oranges.
//iii. If there is a fresh orange, change its state to rotten and decrement the count of fresh oranges, and push the cell into the queue.
//c. Increment the minutes.
//If there are no fresh oranges, return the minutes.
//If there are still fresh oranges, return -1.


class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>();
        int countFreshOrange = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (visited[i][j] == 1) {
                    countFreshOrange++;
                }
            }
        }
        if (countFreshOrange == 0)
            return 0;
        if (q.isEmpty())
            return -1;
        
        int minutes = -1;
        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        countFreshOrange--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++;
        }
        
        if (countFreshOrange == 0)
            return minutes;
        return -1;
    }
}
