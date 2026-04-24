/*
 * Problem: 2201. Count Artifacts That Can Be Extracted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] digs = new boolean[n][n];
        for (int[] pos : dig) {
            digs[pos[0]][pos[1]] = true;
        }
        int res = 0;
        for (int[] artifact : artifacts) {
            res += chk(digs, artifact);
        }
        return res;
    }

    public int chk(boolean[][] digs, int[] artifact) {
        for (int i = artifact[0]; i <= artifact[2]; i++) {
            for (int j = artifact[1]; j <= artifact[3]; j++) {
                if (!digs[i][j])
                    return 0;
            }
        }
        return 1;
    }
}
