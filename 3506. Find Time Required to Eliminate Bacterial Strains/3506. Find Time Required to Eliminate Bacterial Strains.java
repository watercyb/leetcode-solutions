/*
 * Problem: 3506. Find Time Required to Eliminate Bacterial Strains
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-time-required-to-eliminate-bacterial-strains/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public long minEliminationTime(int[] timeReq, int splitTime) {
        Arrays.sort(timeReq);
        long l = timeReq[timeReq.length - 1];
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(timeReq, splitTime, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] timeReq, int splitTime, long mid) {
        long lv = 0;
        long count = 1;
        for (int i = timeReq.length - 1; i >= 0; i--) {
            long l = (mid - timeReq[i]) / splitTime;
            while (lv < l) {
                count *= 2;
                if (count > i)
                    return true;
                lv++;
            }
            if (count-- == 0)
                return false;
        }
        return true;
    }
}
