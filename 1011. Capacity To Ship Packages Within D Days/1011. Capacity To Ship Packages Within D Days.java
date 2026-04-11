/*
 * Problem: 1011. Capacity To Ship Packages Within D Days
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 500 * weights.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(weights, days, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] weights, int days, int mid) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (mid < weights[i])
                return false;
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                if (--days == 0)
                    return false;
            }
        }
        return true;
    }
}
