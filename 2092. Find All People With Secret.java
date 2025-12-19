//You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
//Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
//The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
//Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        boolean[] know = new boolean[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        know[0] = know[firstPerson] = true;

        for (int i = 0; i < meetings.length; ) {
            int t = meetings[i][2];
            List<Integer> list = new ArrayList<>();

            int j = i;
            while (j < meetings.length && meetings[j][2] == t) {
                union(meetings[j][0], meetings[j][1], parent);
                list.add(meetings[j][0]);
                list.add(meetings[j][1]);
                j++;
            }

            for (int p : list)
                if (know[p])
                    know[find(p, parent)] = true;

            for (int p : list)
                know[p] |= know[find(p, parent)];

            for (int p : list)
                parent[p] = p;

            i = j;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (know[i]) res.add(i);
        return res;
    }

    private int find(int x, int[] p) {
        return p[x] == x ? x : (p[x] = find(p[x], p));
    }

    private void union(int a, int b, int[] p) {
        int pa = find(a, p), pb = find(b, p);
        if (pa != pb) p[pb] = pa;
    }
}
