/*
 * Problem: 2211. Count Collisions on a Road
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-collisions-on-a-road/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int countCollisions(String directions) {
        char[] chrs = directions.toCharArray();
        int l = 0;
        while (l < chrs.length && chrs[l] == 'L') {
            l++;
        }
        int r = chrs.length - 1;
        while (r >= l && chrs[r] == 'R') {
            r--;
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (chrs[i] != 'S')
                res++;
        }
        return res;
    }
}
