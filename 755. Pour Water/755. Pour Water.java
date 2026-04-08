/*
 * Problem: 755. Pour Water
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pour-water/?envType=weekly-question&envId=2026-04-08
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++) {
            int l = k - 1;
            int r = k + 1;
            int h = heights[k];
            int idx = k;
            while (l >= 0 && heights[l] <= h) {
                if (heights[l] < h) {
                    h = heights[l];
                    idx = l;
                }
                l--;
            }
            if (idx != k) {
                heights[idx]++;
                continue;
            }
            h = heights[k];
            idx = k;
            while (r < heights.length && heights[r] <= h) {
                if (heights[r] < h) {
                    h = heights[r];
                    idx = r;
                }
                r++;
            }
            if (idx != k) {
                heights[idx]++;
                continue;
            }
            heights[k]++;
        }
        return heights;
    }
}
