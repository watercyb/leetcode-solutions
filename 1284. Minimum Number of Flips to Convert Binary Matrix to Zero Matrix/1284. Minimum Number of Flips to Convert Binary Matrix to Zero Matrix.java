/*
 * Problem: 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int minFlips(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[] seens = new boolean[1 << (r * c)];
        int[] arr = new int[seens.length];
        int left = 0;
        int right = 1;
        seens[0] = true;
        int target = 0;
        int base = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                target += mat[i][j] * base;
                base *= 2;
            }
        }
        int stp = 0;
        while (left < right) {
            int lim = right;
            while (left < lim) {
                int h = arr[left++];
                if (h == target)
                    return stp;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        int hNext = getH(h, i, j, r, c);
                        if (seens[hNext])
                            continue;
                        seens[hNext] = true;
                        arr[right++] = hNext;
                    }
                }
            }
            stp++;
        }
        return -1;
    }

    public int getH(int h, int i, int j, int r, int c) {
        h ^= 1 << (i * c + j);
        if (i > 0)
            h ^= 1 << ((i - 1) * c + j);
        if (i < r - 1)
            h ^= 1 << ((i + 1) * c + j);
        if (j > 0)
            h ^= 1 << (i * c + j - 1);
        if (j < c - 1)
            h ^= 1 << (i * c + j + 1);
        return h;
    }
}
