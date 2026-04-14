/*
 * Problem: 1199. Minimum Time to Build Blocks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-build-blocks/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minBuildTime(int[] blocks, int split) {
        Arrays.sort(blocks);
        int lim = (int) Math.ceil(Math.log(blocks.length) / Math.log(2));
        int l = blocks[blocks.length - 1];
        int r = blocks[blocks.length - 1] + lim * split;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(blocks, split, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] blocks, int split, int mid) {
        int count = 1;
        int prv = 0;
        for (int i = blocks.length - 1; i >= 0; i--) {
            int t = Math.min((mid - blocks[i]) / split, 30);
            count <<= t - prv;
            if (count >= i + 1)
                return true;
            count--;
            prv = t;
        }
        return false;
    }
}
