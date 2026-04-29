/*
 * Problem: 2603. Collect Coins in a Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/collect-coins-in-a-tree/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            links.add(new ArrayList<>());
        }
        int[] counts = new int[coins.length];
        int[] stps = new int[coins.length];
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int res = coins.length;
        int[] Qu = new int[coins.length];
        int l = 0;
        int r = 0;
        for (int i = 0; i < coins.length; i++) {
            if (counts[i] == 1) {
                Qu[r++] = i;
                stps[i] = coins[i];
                counts[i]--;
                res--;
            }
        }
        while (l < r) {
            int current = Qu[l++];
            int nextStp = stps[current] == 0 ? 0 : stps[current] + 1;
            for (int next : links.get(current)) {
                if (counts[next] > 0) {
                    stps[next] = Math.max(Math.max(nextStp, coins[next]), stps[next]);
                    if (--counts[next] == 1) {
                        counts[next] = 0;
                        if (stps[next] < 3) {
                            res--;
                            Qu[r++] = next;
                        }
                    }
                }
            }
        }
        if (res > 0)
            return 2 * (res - 1);
        return 0;
    }
}
