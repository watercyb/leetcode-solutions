/*
 * Problem: 3924. Minimum Threshold Path With Limited Heavy Edges
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-threshold-path-with-limited-heavy-edges/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int[][][] links = new int[n][][];
        int[] unionLinks = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]][];
            unionLinks[i] = i;
        }
        int max = 0;
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = new int[] { edge[1], edge[2] };
            links[edge[1]][--counts[edge[1]]] = new int[] { edge[0], edge[2] };
            int a = find(unionLinks, edge[0]);
            int b = find(unionLinks, edge[1]);
            unionLinks[a] = b;
            max = Math.max(max, edge[2]);
        }
        if (find(unionLinks, source) != find(unionLinks, target))
            return -1;
        arr = new int[n * 4];
        this.counts = new int[n * 4];
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(links, source, target, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int find(int[] unionLinks, int i) {
        if (unionLinks[i] != i)
            unionLinks[i] = find(unionLinks, unionLinks[i]);
        return unionLinks[i];
    }

    int[] arr;
    int[] counts;

    public boolean chk(int[][][] links, int source, int target, int k, int mid) {
        int n = links.length;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        arr[2 * n] = source;
        counts[2 * n] = 0;
        steps[source] = 0;
        int l = 2 * n;
        int r = 2 * n + 1;
        while (l < r) {
            int idx = arr[l];
            int count = counts[l++];
            if (idx == target)
                return true;
            if (steps[idx] != count)
                continue;
            for (int[] next : links[idx]) {
                if (next[1] > mid) {
                    if (count + 1 > k || steps[next[0]] <= count + 1)
                        continue;
                    arr[r] = next[0];
                    counts[r++] = count + 1;
                    steps[next[0]] = count + 1;
                } else {
                    if (steps[next[0]] == count)
                        continue;
                    arr[--l] = next[0];
                    counts[l] = count;
                    steps[next[0]] = count;
                }
            }
        }
        return false;
    }
}
