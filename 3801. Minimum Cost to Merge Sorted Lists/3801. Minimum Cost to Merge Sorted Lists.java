/*
 * Problem: 3801. Minimum Cost to Merge Sorted Lists
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-merge-sorted-lists/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long minMergeCost(int[][] lists) {
        int[][] arrs = new int[1 << lists.length][];
        long[] DP = new long[1 << lists.length];
        for (int i = 0; i < lists.length; i++) {
            arrs[1 << i] = lists[i];
        }
        for (int i = 1; i < (1 << lists.length); i++) {
            if (Integer.bitCount(i) == 1)
                continue;
            long min = Long.MAX_VALUE;
            arrs[i] = merge(arrs[(i - 1) & i], arrs[i - ((i - 1) & i)]);
            for (int j = (i - 1) & i; j > 0; j = (j - 1) & i) {
                long sum = DP[j] + DP[i - j] + arrs[i].length
                        + Math.abs(getMid(arrs[j]) - getMid(arrs[i - j]));
                min = Math.min(min, sum);
            }
            DP[i] = min;
        }
        return DP[(1 << lists.length) - 1];
    }

    public int getMid(int[] arr) {
        return arr[(arr.length - 1) / 2];
    }

    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int l = 0;
        int r = 0;
        int idx = 0;
        while (l < a.length && r < b.length) {
            if (a[l] < b[r]) {
                res[idx++] = a[l++];
            } else {
                res[idx++] = b[r++];
            }
        }
        while (l < a.length) {
            res[idx++] = a[l++];
        }
        while (r < b.length) {
            res[idx++] = b[r++];
        }
        return res;
    }
}
