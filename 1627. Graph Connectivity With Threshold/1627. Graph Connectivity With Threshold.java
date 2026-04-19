/*
 * Problem: 1627. Graph Connectivity With Threshold
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/graph-connectivity-with-threshold/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        if (threshold == 0) {
            List<Boolean> res = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                res.add(true);
            }
            return res;
        }
        int[] links = new int[n + 1];
        for (int i = 1; i < links.length; i++) {
            links[i] = i;
        }
        for (int i = threshold + 1; i <= n / 2; i++) {
            for (int j = i * 2; j <= n; j += i) {
                int a = find(links, i);
                int b = find(links, j);
                if (a != b)
                    links[a] = b;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(find(links, query[0]) == find(links, query[1]));
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
