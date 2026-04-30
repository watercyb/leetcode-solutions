/*
 * Problem: 2732. Find a Good Subset of the Matrix
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-a-good-subset-of-the-matrix/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[] hasMask = new boolean[1 << c];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int mask = 0;
            for (int j = 0; j < c; j++) {
                mask = (mask << 1) | grid[i][j];
            }
            if (mask == 0) {
                res.add(i);
                return res;
            }
            hasMask[mask] = true;
        }
        for (int i = 0; i < hasMask.length; i++) {
            if (!hasMask[i])
                continue;
            for (int j = i + 1; j < hasMask.length; j++) {
                if (!hasMask[j])
                    continue;
                if ((i & j) == 0) {
                    for (int k = 0; k < r; k++) {
                        int mask = 0;
                        for (int l = 0; l < c; l++) {
                            mask = (mask << 1) | grid[k][l];
                        }
                        if (mask == i) {
                            res.add(k);
                            i = -1;
                            if (res.size() == 2)
                                return res;
                        }
                        if (mask == j) {
                            res.add(k);
                            j = -1;
                            if (res.size() == 2)
                                return res;
                        }
                    }
                }
            }
        }
        return res;
    }
}

