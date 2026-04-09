/*
 * Problem: 838. Push Dominoes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/push-dominoes/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String pushDominoes(String dominoes) {
        char[] chrs = dominoes.toCharArray();
        int prv = 0;
        int prvIdx = 0;
        char[] res = new char[dominoes.length()];
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'L') {
                if (prv <= 0) {
                    fill(res, 'L', prvIdx, i);
                } else {
                    int l = prvIdx;
                    int r = i;
                    while (l < r) {
                        res[l] = 'R';
                        res[r] = 'L';
                        l++;
                        r--;
                    }
                    if (l == r)
                        res[l] = '.';
                }
                prv = -1;
                prvIdx = i;
            } else if (chrs[i] == 'R') {
                if (prv <= 0) {
                    fill(res, '.', prvIdx - prv, i);
                } else {
                    fill(res, 'R', prvIdx, i);
                }
                prv = 1;
                prvIdx = i;
            }
        }
        if (prv <= 0) {
            fill(res, '.', prvIdx - prv, res.length - 1);
        } else {
            fill(res, 'R', prvIdx, res.length - 1);
        }
        return new String(res);
    }

    public void fill(char[] chrs, char chr, int i, int j) {
        while (i <= j) {
            chrs[i++] = chr;
        }
    }
}
