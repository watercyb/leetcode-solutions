/*
 * Problem: 1891. Cutting Ribbons
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cutting-ribbons/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1;
        int r = 0;
        long sum = 0;
        for (int i = 0; i < ribbons.length; i++) {
            r = Math.max(ribbons[i], r);
            sum += ribbons[i];
        }
        if (sum < k)
            return 0;
        r = Math.min((int) (sum / k), r) + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(ribbons, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] ribbons, int k, int mid) {
        for (int i = 0; i < ribbons.length; i++) {
            k -= ribbons[i] / mid;
            if (k <= 0)
                return true;
        }
        return false;
    }
}
