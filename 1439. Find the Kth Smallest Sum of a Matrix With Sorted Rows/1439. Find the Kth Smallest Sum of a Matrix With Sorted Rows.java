/*
 * Problem: 1439. Find the Kth Smallest Sum of a Matrix With Sorted Rows
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < mat.length; i++) {
            l += mat[i][0];
            r += mat[i][mat[0].length - 1];
        }
        int sl = l;
        while (l < r) {
            int mid = (l + r) >>> 1;
            kL = k;
            if (dfs(mat, mat.length - 1, mid - sl)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int kL = 0;

    public boolean dfs(int[][] mat, int i, int mid) {
        if (i < 0) {
            return --kL == 0;
        }
        for (int in : mat[i]) {
            if (mid < in - mat[i][0])
                break;
            if (dfs(mat, i - 1, mid - in + mat[i][0]))
                return true;
        }
        return false;
    }
}
