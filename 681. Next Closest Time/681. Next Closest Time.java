/*
 * Problem: 681. Next Closest Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/next-closest-time/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public String nextClosestTime(String time) {
        char[] chrs = time.toCharArray();
        boolean[] has = new boolean['9' + 1];
        char min = '9';
        has[chrs[0]] = true;
        min = (char) Math.min(chrs[0], min);
        has[chrs[1]] = true;
        min = (char) Math.min(chrs[1], min);
        has[chrs[3]] = true;
        min = (char) Math.min(chrs[3], min);
        has[chrs[4]] = true;
        min = (char) Math.min(chrs[4], min);
        for (int i = chrs[4] + 1; i <= '9'; i++) {
            if (has[i]) {
                chrs[4] = (char) i;
                return new String(chrs);
            }
        }
        for (int i = chrs[3] + 1; i < '6'; i++) {
            if (has[i]) {
                chrs[3] = (char) i;
                chrs[4] = min;
                return new String(chrs);
            }
        }
        int lim = chrs[0] == '2' ? '3' : '9';
        for (int i = chrs[1] + 1; i <= lim; i++) {
            if (has[i]) {
                chrs[1] = (char) i;
                chrs[3] = min;
                chrs[4] = min;
                return new String(chrs);
            }
        }
        for (int i = chrs[0] + 1; i <= '2'; i++) {
            if (has[i]) {
                chrs[0] = (char) i;
                chrs[1] = min;
                chrs[3] = min;
                chrs[4] = min;
                return new String(chrs);
            }
        }
        chrs[0] = min;
        chrs[1] = min;
        chrs[3] = min;
        chrs[4] = min;
        return new String(chrs);
    }
}
