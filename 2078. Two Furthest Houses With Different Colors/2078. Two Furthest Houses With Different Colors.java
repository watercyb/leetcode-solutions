/*
 * Problem: 2078. Two Furthest Houses With Different Colors
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-furthest-houses-with-different-colors/?envType=daily-question&envId=2026-04-20
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxDistance(int[] colors) {
        int l = 0;
        int r = colors.length - 1;
        while (colors[l] == colors[r]) {
            l++;
        }
        while (colors[r] == colors[0]) {
            r--;
        }
        return Math.max(colors.length - 1 - l, r);
    }
}
