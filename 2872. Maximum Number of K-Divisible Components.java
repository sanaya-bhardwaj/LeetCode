//There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.
//A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.
//Return the maximum number of components in any valid split.

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int[] ans = new int[1];
        dfs(adj,values,0,-1,ans,k);
        return ans[0];
    }
    static int dfs(List<List<Integer>> adj, int[] values, int node, int parent, int[] ans, int k) {
        int sum = values[node];
        for(int temp : adj.get(node)) {
            if(temp != parent) {
                sum += dfs(adj,values,temp,node,ans,k);
            }
        }
        if(sum % k == 0) ans[0]++;
        return sum % k;
    }
}
