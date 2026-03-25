/*
 * Problem: 76. Minimum Window Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-window-substring/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String minWindow(String s, String t) {
        char[] chrS = s.toCharArray();
        char[] chrT = t.toCharArray();
       
        int[] counts = new int['z' + 1];
        int count = 0;
        for (int i = 0; i < chrT.length; i++) {
            if (counts[chrT[i]]++ == 0)
                count++;
        }
        int l = 0;
        int r = 0;
        int[] min = { -1, Integer.MAX_VALUE };
        while (l <= chrS.length) {
            while (count > 0 && r < chrS.length) {
                if (--counts[chrS[r++]] == 0)
                    count--;
            }
            if (r == chrS.length && count > 0)
                break;
            if (r - l < min[1]) {
                min[1] = r - l;
                min[0] = l;
            }
            while (count == 0) {
                if (++counts[chrS[l++]] == 1)
                    count++;
            }
            if (r - l + 1 < min[1]) {
                min[1] = r - l + 1;
                min[0] = l - 1;
            }
        }
        if (min[0] == -1)
            return "";
        return s.substring(min[0], min[1] + min[0]);
    }
}
