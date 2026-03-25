/*
 * Problem: 42. Trapping Rain Water
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/trapping-rain-water/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        while (l < r) {
            if (maxL > maxR) {
                res += maxR - height[r--];
                maxR = Math.max(height[r], maxR);
            } else {
                res += maxL - height[l++];
                maxL = Math.max(height[l], maxL);
            }
        }
        return res;
    }
}
