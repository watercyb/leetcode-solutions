/*
 * Problem: 2604. Minimum Time to Eat All Grains
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-eat-all-grains/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);
        int l = 0;
        int r = grains[grains.length - 1] - grains[0] + Math.abs(hens[0] - grains[0]);
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(hens, grains, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] hens, int[] grains, int mid) {
        int idx = 0;
        for (int hen : hens) {
            int lim = hen;
            if (hen <= grains[idx]) {
                lim += mid;
            } else {
                if (hen - grains[idx] > mid)
                    return false;
                lim += Math.max(Math.max(mid - 2 * (hen - grains[idx]), (mid - hen + grains[idx]) / 2), 0);
            }
            while (idx < grains.length && grains[idx] <= lim) {
                idx++;
            }
            if (idx == grains.length)
                return true;
        }
        return false;
    }
}
