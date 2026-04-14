/*
 * Problem: 1198. Find Smallest Common Element in All Rows
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-smallest-common-element-in-all-rows/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] idx = new int[mat.length];
        int count = 0;
        int i = 0;
        int prv = -1;
        while (count < mat.length - 1) {
            int tmp = findCommon(mat, idx, i);
            if (tmp == -1)
                return -1;
            if (tmp == prv) {
                count++;
            } else {
                prv = tmp;
                count = 1;
            }
            i = (i + 1) % mat.length;
        }
        return mat[0][idx[0]];
    }

    public int findCommon(int[][] mat, int[] idx, int i) {
        int j = (i + 1) % idx.length;
        while (mat[i][idx[i]] != mat[j][idx[j]]) {
            if (mat[i][idx[i]] < mat[j][idx[j]]) {
                if (++idx[i] == mat[0].length)
                    return -1;
            } else {
                if (++idx[j] == mat[0].length)
                    return -1;
            }
        }
        return mat[i][idx[i]];
    }
}
