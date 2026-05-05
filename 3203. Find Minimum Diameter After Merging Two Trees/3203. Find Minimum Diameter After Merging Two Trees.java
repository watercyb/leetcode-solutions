/*
 * Problem: 3203. Find Minimum Diameter After Merging Two Trees
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int a = getMin(edges1);
        int b = getMin(edges2);
        return Math.max((a + 1) / 2 + (b + 1) / 2 + 1, Math.max(a, b));
    }

    public int getMin(int[][] edges) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        int[][] links = new int[edges.length + 1][];
        for (int i = 0; i < links.length; i++) {
            List<Integer> list = lists.get(i);
            links[i] = new int[list.size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = list.get(j);
            }
        }
        max = 0;
        dfs(links, 0, -1);
        return max;
    }

    int max;

    public int dfs(int[][] links, int i, int prv) {
        int a = 0;
        int b = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            int res = dfs(links, next, i);
            if (res > a) {
                b = a;
                a = res;
            } else if (res > b) {
                b = res;
            }
        }
        max = Math.max(a + b, max);
        return a + 1;
    }
}
