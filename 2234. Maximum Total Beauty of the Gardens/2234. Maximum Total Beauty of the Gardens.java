/*
 * Problem: 2234. Maximum Total Beauty of the Gardens
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        long n = flowers.length;
        long[] sums = new long[flowers.length];
        long sum = 0;
        int l = 0;
        while (l < flowers.length) {
            sums[l] = (long) l * flowers[l] - sum;
            if (flowers[l] >= target)
                break;
            sum += flowers[l];
            l++;
        }
        l--;
        long res = 0;
        if (n * target - sum <= newFlowers)
            res = n * full;
        int r = flowers.length;
        while (newFlowers >= 0) {
            if (l >= r)
                l = r - 1;
            while (l >= 0 && sums[l] > newFlowers) {
                l--;
            }
            long p = 0;
            if (l >= 0) {
                long tmp = (newFlowers - sums[l]) / (long) (l + 1);
                if (tmp + flowers[l] >= target) {
                    p = (long) (target - 1) * partial;
                } else {
                    p = ((long) flowers[l] + (newFlowers - sums[l]) / (l + 1)) * partial;
                }
            }
            res = Math.max(p + (n - r) * full, res);
            r--;
            if (r < 0)
                break;
            newFlowers -= Math.max((long) target - (long) flowers[r], 0);
        }
        return res;
    }
}
