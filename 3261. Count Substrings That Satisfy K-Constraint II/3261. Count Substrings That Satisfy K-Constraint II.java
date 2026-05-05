/*
 * Problem: 3261. Count Substrings That Satisfy K-Constraint II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        char[] chrs = s.toCharArray();
        int[] ranges = new int[chrs.length];
        long[] sums = new long[chrs.length + 1];
        int j = -1;
        int[] counts = new int[2];
        int count = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && count < 2) {
                j++;
                if (j == chrs.length)
                    break;
                if (counts[chrs[j] - '0']++ == k)
                    count++;
            }
            ranges[i] = j - 1;
            sums[j - 1]++;
            if (counts[chrs[i] - '0']-- == k + 1)
                count--;
        }
        long sum = sums[chrs.length - 1];
        for (int i = chrs.length - 2; i >= 0; i--) {
            sum += sums[i] - 1;
            sums[i] = sums[i + 1] + sum;
        }
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int right = ranges[l];
            if (r <= right) {
                res[i] = (2l + r - l) * (r - l + 1) / 2;
            } else {
                res[i] = (2l + right - l) * (right - l + 1) / 2 + sums[right + 1] - sums[r + 1];
            }
        }
        return res;
    }
}
