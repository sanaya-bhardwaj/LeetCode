/*You are given a directed, weighted graph with n nodes labeled from 0 to n - 1, and an array edges where edges[i] = [ui, vi, wi] represents a directed edge from node ui to node vi with cost wi.
Each node ui has a switch that can be used at most once: when you arrive at ui and have not yet used its switch, you may activate it on one of its incoming edges vi → ui reverse that edge to ui → vi and immediately traverse it.
The reversal is only valid for that single move, and using a reversed edge costs 2 * wi.
Return the minimum total cost to travel from node 0 to node n - 1. If it is not possible, return -1.*/

class Solution {
    static class Edge {
        int v;
        int w;
        Edge(int v, int w) {
            this.v = v; this.w = w;
        }
    }

    static class State {
        int dist;
        int node;
        State(int dist, int node) { 
            this.dist = dist; this.node = node; 
        }
    }

    public int minCost(int n, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, 2 * w));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int weight = cur.dist;
            int node = cur.node;

            if (weight > ans[node]) 
                continue;

            for (Edge e : graph.get(node)) {
                int nd = e.v;
                int wt = e.w;
                if (ans[node] != Integer.MAX_VALUE && wt + weight < ans[nd]) {
                    ans[nd] = wt + weight;
                    pq.add(new State(ans[nd], nd));
                }
            }
        }

        return ans[n - 1] == Integer.MAX_VALUE ? -1 : ans[n - 1];
    }
}
