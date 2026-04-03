/*
 * Problem: 497. Random Point in Non-overlapping Rectangles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {

    int[][] rects;
    int[] sums;
    Random random = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        sums = new int[rects.length + 1];
        for (int i = 0; i < rects.length; i++) {
            sums[i + 1] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1) + sums[i];
        }
    }

    public int[] pick() {
        int idx = binarySearch(random.nextInt(sums[sums.length - 1]));
        int r = random.nextInt(sums[idx] - sums[idx - 1]);
        int mod = rects[idx - 1][2] - rects[idx - 1][0] + 1;
        return new int[] { rects[idx - 1][0] + r % mod, rects[idx - 1][1] + r / mod };
    }

    public int binarySearch(int target) {
        int l = 1;
        int r = sums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (sums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
