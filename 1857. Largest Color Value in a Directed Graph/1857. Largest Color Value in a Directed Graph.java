/*
 * Problem: 1857. Largest Color Value in a Directed Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        char[] chrs = colors.toCharArray();
        List<List<Integer>> Links = new ArrayList<>();
        int[][] counts = new int[chrs.length][26];
        for (int i = 0; i < chrs.length; i++) {
            Links.add(new ArrayList<>());
        }
        int[] inCounts = new int[chrs.length];
        for (int[] edge : edges) {
            Links.get(edge[0]).add(edge[1]);
            inCounts[edge[1]]++;
        }
        Queue<Integer> Qu = new LinkedList<>();
        for (int i = 0; i < chrs.length; i++) {
            if (inCounts[i] == 0) {
                counts[i][chrs[i] - 'a']++;
                Qu.offer(i);
            }
        }
        int res = 1;
        while (!Qu.isEmpty()) {
            int tmp = Qu.poll();
            if (Links.get(tmp).size() == 0) {
                for (int i = 0; i < 26; i++) {
                    res = Math.max(counts[tmp][i], res);
                }
            }
            for (int next : Links.get(tmp)) {
                inCounts[next]--;
                for (int i = 0; i < 26; i++) {
                    counts[next][i] = Math.max(counts[tmp][i], counts[next][i]);
                }
                if (inCounts[next] == 0) {
                    counts[next][chrs[next] - 'a']++;
                    Qu.offer(next);
                }
            }
        }
        for (int count : inCounts) {
            if (count > 0)
                return -1;
        }
        return res;
    }
}
