/*
 * Problem: 753. Cracking the Safe
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/cracking-the-safe/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String crackSafe(int n, int k) {
        int max = (int) Math.pow(k, n);
        boolean[] seens = new boolean[max + 1];
        seens[0] = true;
        dfs(seens, 0, 0, k, max / k);
        for (int i = 0; i < n - 1; i++) {
            SB.append('0');
        }
        return SB.reverse().toString();
    }

    StringBuilder SB = new StringBuilder();

    public void dfs(boolean[] seens, int h, int last, int k, int base) {
        h = h % base * k;
        for (int j = 0; j < k; j++) {
            if (!seens[h + j]) {
                seens[h + j] = true;
                dfs(seens, h + j, j, k, base);
            }
        }
        SB.append(last);
    }
}
