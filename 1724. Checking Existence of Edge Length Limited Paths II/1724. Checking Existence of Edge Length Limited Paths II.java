/*
 * Problem: 1724. Checking Existence of Edge Length Limited Paths II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths-ii/
 * Language: java
 * Date: 2026-04-20
 */

class DistanceLimitedPathsExist {
    int n;
    int[] links;
    int[] weights;
    int[] ranks;

    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        this.n = n;
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        links = new int[n];
        weights = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
        }
        for (int[] edge : edgeList) {
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a == b)
                continue;
            if (ranks[a] < ranks[b]) {
                links[a] = b;
                weights[a] = edge[2];
            } else if (ranks[a] > ranks[b]) {
                links[b] = a;
                weights[b] = edge[2];
            } else {
                links[a] = b;
                weights[a] = edge[2];
                ranks[b]++;
            }
        }
    }

    public boolean query(int p, int q, int limit) {
        int a = find(links, p, limit);
        int b = find(links, q, limit);
        return a == b;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            return find(links, links[i]);
        return links[i];
    }

    public int find(int[] links, int i, int lim) {
        if (links[i] == i || weights[i] >= lim)
            return i;
        return find(links, links[i], lim);
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */
