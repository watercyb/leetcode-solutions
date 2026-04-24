/*
 * Problem: 2101. Detonate the Maximum Bombs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/detonate-the-maximum-bombs/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> Links = new ArrayList<>();
        long[] ranges = new long[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            Links.add(new ArrayList<>());
            ranges[i] = (long) bombs[i][2] * bombs[i][2];
        }
        for (int i = 0; i < bombs.length - 1; i++) {
            for (int j = i + 1; j < bombs.length; j++) {
                long a = bombs[i][0] - bombs[j][0];
                long b = bombs[i][1] - bombs[j][1];
                long tmp = a * a + b * b;
                if (tmp <= ranges[i])
                    Links.get(i).add(j);
                if (tmp <= ranges[j])
                    Links.get(j).add(i);
            }
        }
        int res = 0;
        boolean[] used = new boolean[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            if (!used[i])
                res = Math.max(dfs(used, Links, new boolean[bombs.length], i), res);
        }
        return res;
    }

    public int dfs(boolean[] used, List<List<Integer>> Links, boolean[] seens, int i) {
        used[i] = true;
        seens[i] = true;
        int res = 1;
        for (int next : Links.get(i)) {
            if (!seens[next]) {
                res += dfs(used, Links, seens, next);
            }
        }
        return res;
    }
}
