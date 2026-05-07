/*
 * Problem: 3449. Maximize the Minimum Game Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-the-minimum-game-score/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxScore(int[] points, int m) {
        int max = 0;
        for (int point : points) {
            max = Math.max(point, max);
        }
        long l = 1;
        long r = (long) max * (m / points.length) + 1;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (!chk(points, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] points, long m, long mid) {
        long prv = 0;
        for (int i = 0; i < points.length - 1 && m >= 0; i++) {
            long count = (mid + points[i] - 1) / points[i];
            m -= count;
            count--;
            if (m < 0)
                return false;
            if (prv > count) {
                m -= prv - count;
                prv = 0;
            } else {
                prv = count - prv;
            }
        }
        long count = (mid + points[points.length - 1] - 1) / points[points.length - 1];
        m -= count;
        count--;
        if (prv > count) {
            return prv - count - 1 <= m;
        } else {
            return count - prv <= m;
        }
    }
}
