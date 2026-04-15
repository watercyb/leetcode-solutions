/*
 * Problem: 1245. Tree Diameter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/tree-diameter/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int treeDiameter(int[][] edges) {
        List<Integer>[] links = new ArrayList[edges.length + 1];
        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }
        dfs(links, 0, -1);
        return res;
    }

    int res = 0;

    public int dfs(List<Integer>[] links, int i, int prv) {
        int a = 0;
        int b = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int resNext = dfs(links, next, i);
            if (resNext > a) {
                b = a;
                a = resNext;
            } else if (resNext > b) {
                b = resNext;
            }
        }
        res = Math.max(a + b, res);
        return Math.max(a, b) + 1;
    }
}
