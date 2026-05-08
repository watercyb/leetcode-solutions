/*
 * Problem: 3593. Minimum Increments to Equalize Leaf Paths
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-increments-to-equalize-leaf-paths/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        dfs(lists, cost, 0, -1);
        return res;
    }

    int res = 0;

    public long dfs(List<Integer>[] lists, int[] cost, int i, int prv) {
        long max = 0;
        int count = 0;
        int maxCount = 0;
        for (int next : lists[i]) {
            if (next == prv)
                continue;
            count++;
            long sum = dfs(lists, cost, next, i);
            if (max < sum) {
                max = sum;
                maxCount = 1;
            } else if (max == sum) {
                maxCount++;
            }
        }
        res += count - maxCount;
        return max + cost[i];
    }
}
