/*
 * Problem: 1531. String Compression II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/string-compression-ii/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] chrs = s.toCharArray();
        int[][] DP = new int[chrs.length + 1][k + 1];
        for (int i = 0; i < chrs.length; i++) {
            for (int j = k; j >= 0; j--) {
                if (k - j > i)
                    break;
                if (chrs.length - i <= j)
                    continue;
                DP[i + 1][j] = j < k ? DP[i][j + 1] : i + 1;
                int diff = 0;
                int same = 1;
                for (int l = i; l >= 0; l--) {
                    int kTmp = j + diff;
                    if (kTmp > k)
                        break;
                    if (DP[l][kTmp]==0) {
                        DP[i + 1][j] = getLength(same);
                        break;
                    }
                    if (chrs[l - 1] == chrs[i]) {
                        same++;
                    } else {
                        diff++;
                        DP[i + 1][j] = Math.min(DP[l][kTmp] + getLength(same), DP[i + 1][j]);
                    }
                }
            }
        }
        return DP[chrs.length][0];
    }

    public int getLength(int same) {
        return same == 1 ? 1 : same < 10 ? 2 : same < 100 ? 3 : 4;
    }
}
