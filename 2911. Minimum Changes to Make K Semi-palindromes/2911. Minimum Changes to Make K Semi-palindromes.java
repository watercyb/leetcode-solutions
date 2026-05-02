/*
 * Problem: 2911. Minimum Changes to Make K Semi-palindromes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minimumChanges(String s, int k) {
        char[] chrs = s.toCharArray();
        memePal = new int[chrs.length][chrs.length];
        return dfs(new int[chrs.length + 1][k + 1], chrs, 0, k) - k;
    }

    public int dfs(int[][] memeDfs, char[] chrs, int i, int k) {
        if (memeDfs[i][k] > 0)
            return memeDfs[i][k];
        if (i >= chrs.length - 1)
            return memeDfs[i][k] = Integer.MAX_VALUE / 2;
        if (k == 1)
            return memeDfs[i][k] = getMin(chrs, i, chrs.length - 1);
        int res = Integer.MAX_VALUE / 2;
        for (int j = i + 1; j < chrs.length; j++) {
            res = Math.min(getMin(chrs, i, j) + dfs(memeDfs, chrs, j + 1, k - 1), res);
        }
        return memeDfs[i][k] = res;
    }

    int[][] memePal;

    public int getMin(char[] chrs, int i, int j) {
        if (memePal[i][j] > 0)
            return memePal[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= (j - i + 1) / 2; k++) {
            if ((j - i + 1) % k != 0)
                continue;
            int count = 0;
            for (int l = 0; l < k; l++) {
                int left = i + l;
                int right = j - k + 1 + l;
                while (left < right) {
                    if (chrs[left] != chrs[right])
                        count++;
                    left += k;
                    right -= k;
                }
            }
            min = Math.min(count, min);
        }
        return memePal[i][j] = min + 1;
    }
}
