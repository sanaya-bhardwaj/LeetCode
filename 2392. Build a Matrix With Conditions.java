//You are given a positive integer k. You are also given:
//a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
//a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
//The two arrays contain integers from 1 to k.
//You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.
//The matrix should also satisfy the following conditions:
//The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.
//The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.
//Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row_sorting = topo_sort(rowConditions, k);
        List<Integer> col_sorting = topo_sort(colConditions, k);
        if (row_sorting.isEmpty() || col_sorting.isEmpty())
            return new int[0][0];

        Map<Integer, int[]> value_position = new HashMap<>();
        for (int n = 1; n <= k; ++n) {
            value_position.put(n, new int[2]);  // element -> [row_index, col_index]
        }
        for (int ind = 0; ind < row_sorting.size(); ++ind) {
            value_position.get(row_sorting.get(ind))[0] = ind;
        }
        for (int ind = 0; ind < col_sorting.size(); ++ind) {
            value_position.get(col_sorting.get(ind))[1] = ind;
        }

        int[][] res = new int[k][k];
        for (int value = 1; value <= k; ++value) {
            int row = value_position.get(value)[0];
            int column = value_position.get(value)[1];
            res[row][column] = value;
        }

        return res;
    }

    // return True if all okay and return False if cycle was found
    private boolean dfs(int src, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> cur_path, List<Integer> res) {
        if (cur_path.contains(src)) return false;  // cycle detected
        if (visited.contains(src)) return true;  // all okay, but we've already visited this node

        visited.add(src);
        cur_path.add(src);

        for (int neighbor : graph.getOrDefault(src, Collections.emptyList())) {
            if (!dfs(neighbor, graph, visited, cur_path, res))  // if any child returns false
                return false;
        }

        cur_path.remove(src);  // backtrack path
        res.add(src);
        return true;
    }

    // if there will be cycle - return empty array, in other case return 1d array as described above
    private List<Integer> topo_sort(int[][] edges, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cur_path = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int src = 1; src <= k; ++src) {
            if (!dfs(src, graph, visited, cur_path, res))
                return Collections.emptyList();
        }

        Collections.reverse(res);  // we will have res as reversed so we need to reverse it one more time
        return res;
    }
}
