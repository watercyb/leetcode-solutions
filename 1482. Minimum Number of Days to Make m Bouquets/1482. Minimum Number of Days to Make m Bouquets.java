/*
 * Problem: 1482. Minimum Number of Days to Make m Bouquets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int day : bloomDay) {
            max = Math.max(max, day);
            min = Math.min(min, day);
        }
        int l = min;
        int r = max + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(bloomDay, m, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(chk(bloomDay, m, k, 7));
        if (l == max + 1)
            return -1;
        return l;
    }

    public boolean chk(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                if (++count == k) {
                    if (--m == 0)
                        return true;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
