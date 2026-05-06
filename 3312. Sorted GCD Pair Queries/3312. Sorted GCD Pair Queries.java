/*
 * Problem: 3312. Sorted GCD Pair Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sorted-gcd-pair-queries/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        long[] pairs = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            int count = 0;
            for (int j = i; j <= max; j += i) {
                count += counts[j];
                pairs[i] -= pairs[j];
            }
            pairs[i] += (long) count * (count - 1) / 2;
        }
        for (int i = 1; i < pairs.length; i++) {
            pairs[i] += pairs[i - 1];
        }
        int[] res = new int[queries.length];
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            res[i] = binarySearch(pairs, queries[i] + 1);
        }
        return res;
    }

    public int binarySearch(long[] pairs, long target) {
        int l = 0;
        int r = pairs.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (pairs[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
