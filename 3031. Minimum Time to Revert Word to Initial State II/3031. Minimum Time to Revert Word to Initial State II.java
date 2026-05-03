/*
 * Problem: 3031. Minimum Time to Revert Word to Initial State II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        char[] chrs = word.toCharArray();
        int[] lsp = getMax(chrs);
        int len = lsp[lsp.length - 1];
        while (len > 0 && (chrs.length - len) % k != 0) {
            len = lsp[len - 1];
        }
        return (chrs.length - len + k - 1) / k;
    }

    public int[] getMax(char[] chrs) {
        int[] lsp = new int[chrs.length];
        int len = 0;
        int idx = 1;
        while (idx < chrs.length) {
            if (chrs[idx] == chrs[len]) {
                len++;
                lsp[idx] = len;
                idx++;
            } else {
                if (len == 0) {
                    idx++;
                } else {
                    len = lsp[len - 1];
                }
            }
        }
        return lsp;
    }
}
