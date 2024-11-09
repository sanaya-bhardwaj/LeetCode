//You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
//You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
//In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. 
//Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. 
//The entrance does not count as an exit.
//Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        while(! queue.isEmpty()) {
            int[] curr = queue.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            for(int i = 0; i < 4; i++) {
                int x = r + dx[i];
                int y = c + dy[i];

                if(x == -1 || y == -1 || x == m || y == n) continue;
                if(maze[x][y] == '+') continue;
                if(x == 0 || y == 0 || x == m - 1 || y == n - 1) return dist + 1;
                maze[x][y] = '+';
                queue.add(new int[] {x, y, dist + 1});
            }
        }
        return -1;
    }
}
