//You are given an integer c representing c power stations, each with a unique identifier id from 1 to c (1‑based indexing).
//These stations are interconnected via n bidirectional cables, represented by a 2D array connections, where each element connections[i] = [ui, vi] indicates a connection between station ui and station vi. Stations that are directly or indirectly connected form a power grid.
//Initially, all stations are online (operational).
//You are also given a 2D array queries, where each query is one of the following two types:
//[1, x]: A maintenance check is requested for station x. If station x is online, it resolves the check by itself. If station x is offline, the check is resolved by the operational station with the smallest id in the same power grid as x. If no operational station exists in that grid, return -1.
//[2, x]: Station x goes offline (i.e., it becomes non-operational).
//Return an array of integers representing the results of each query of type [1, x] in the order they appear.
//Note: The power grid preserves its structure; an offline (non‑operational) node remains part of its grid and taking it offline does not alter connectivity.

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] parent = new int[c + 1];
        for (int i = 0; i <= c; i++) parent[i] = i;

        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            public int applyAsInt(int i) {
                while (parent[i] != i) {
                    parent[i] = parent[parent[i]];
                    i = parent[i];
                }
                return i;
            }
        };

        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            int ui = find.applyAsInt(u), vi = find.applyAsInt(v);
            if (ui != vi) 
                parent[vi] = ui;
        }

        int[] next_node = new int[c + 1], comp_min = new int[c + 1], last = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            int r = find.applyAsInt(i);
            if (comp_min[r] == 0) comp_min[r] = i;
            else next_node[last[r]] = i;
            last[r] = i;
        }

        boolean[] offline = new boolean[c + 1];
        List<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int t = q[0], x = q[1];
            if (t == 1) {
                if (!offline[x]) res.add(x);
                else {
                    int r = find.applyAsInt(x);
                    int m = comp_min[r];
                    res.add(m != 0 ? m : -1);
                }
            } else {
                if (offline[x]) 
                    continue;
                offline[x] = true;
                int r = find.applyAsInt(x);
                if (comp_min[r] == x) {
                    int y = next_node[x];
                    while (y != 0 && offline[y]) y = next_node[y];
                    comp_min[r] = y;
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) 
            ans[i] = res.get(i);
        return ans;
    }
}
