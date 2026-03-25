/*
 * Problem: 11. Container With Most Water
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/container-with-most-water/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while (l<r) {
            max=Math.max(max,Math.min(height[l],height[r])*(r-l));
            int lastHeight=Math.min(height[l],height[r]);
            while (l<height.length&&height[l]<=lastHeight) {
                l++;
            }
            while (r>=0&&height[r]<=lastHeight) {
                r--;
            }
        }
        return max;
    }
}
