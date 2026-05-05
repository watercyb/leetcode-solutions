/*
 * Problem: 3206. Alternating Groups I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/alternating-groups-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int res = 0;
        if (colors[0] != colors[1] && colors[0] != colors[colors.length - 1])
            res++;
        if (colors[colors.length - 1] != colors[colors.length - 2] && colors[colors.length - 1] != colors[0])
            res++;
        for (int i = 1; i < colors.length - 1; i++) {
            if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1])
                res++;
        }
        return res;
    }
}
