/*
 * Problem: 960. Delete Columns to Make Sorted III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minDeletionSize(String[] strs) {
        int len = strs[0].length();
        int[] DP = new int[len];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            DP[i] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (chk(strs, i, j))
                    DP[i] = Math.min(DP[i], DP[j] + i - j - 1);
            }
            res = Math.min(res, DP[i] + len - 1 - i);
        }
        return res;
    }

    public boolean chk(String[] strs, int i, int j) {
        for (String str : strs) {
            if (str.charAt(i) < str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
