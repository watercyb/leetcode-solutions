/*
 * Problem: 3443. Maximum Manhattan Distance After K Changes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxDistance(String s, int k) {
        k *= 2;
        int x = 0;
        int y = 0;
        int sum = 0;
        int res = 0;
        for (char chr : s.toCharArray()) {
            switch (chr) {
                case 'N':
                    x--;
                    break;
                case 'W':
                    y--;
                    break;
                case 'S':
                    x++;
                    break;
                case 'E':
                    y++;
                    break;
            }
            sum++;
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            res = Math.max(absX + absY + Math.min(sum - absX - absY, k), res);
        }
        return res;
    }
}
