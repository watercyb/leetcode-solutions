/*
 * Problem: 3480. Maximize Subarrays After Removing One Conflicting Pair
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-subarrays-after-removing-one-conflicting-pair/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int[][] arr = conflictingPairs;
        int[] maxes1 = new int[n + 1];
        int[] maxes2 = new int[n + 1];
        for (int[] pair : arr) {
            int a = pair[0];
            int b = pair[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (maxes1[b] < a) {
                maxes2[b] = maxes1[b];
                maxes1[b] = a;
            } else if (maxes2[b] < a) {
                maxes2[b] = a;
            }
        }
        int l = 0;
        int r = 0;
        long res = 0;
        long[] increases = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            while (l <= n && maxes1[l] < i) {
                l++;
            }
            if (l > n) {
                long len = n + 1 - i;
                res += (len + 1) * len / 2;
                break;
            }
            if (maxes2[l] < i) {
                if (r <= l)
                    r = l + 1;
                while (r <= n && maxes1[r] < i) {
                    r++;
                }
                increases[l] += Math.min(r, n + 1) - l;
            }
            res += l - i;
        }
        long max = 0;
        for (long increase : increases) {
            max = Math.max(increase, max);
        }
        return res + max;
    }
}
