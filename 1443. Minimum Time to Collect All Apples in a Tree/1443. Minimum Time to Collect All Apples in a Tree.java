/*
 * Problem: 1443. Minimum Time to Collect All Apples in a Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] links = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        int[] counts = new int[n];
        counts[0] = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        boolean[] apples = new boolean[n];
        for (int i = 0; i < n; i++) {
            apples[i] = hasApple.get(i);
        }
        int[] arr = new int[n];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1)
                arr[r++] = i;
        }
        int res = 0;
        while (l < r) {
            int current = arr[l++];
            counts[current]--;
            if (apples[current])
                res += 2;
            for (int next : links[current]) {
                if (counts[next]-- == 2)
                    arr[r++] = next;
                apples[next] |= apples[current];
            }
        }
        return res;
    }
}
