/*
 * Problem: 649. Dota2 Senate
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/dota2-senate/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public String predictPartyVictory(String senate) {
        char[] chrs = senate.toCharArray();
        int ban = 0;
        while (senate.length() > 0) {
            int r = 0;
            int d = 0;
            for (int i = 0; i < chrs.length; i++) {
                if (chrs[i] == 'R') {
                    if (ban >= 0) {
                        r++;
                    } else {
                        chrs[i] = ' ';
                    }
                    ban++;
                } else if (chrs[i] == 'D') {
                    if (ban <= 0) {
                        d++;
                    } else {
                        chrs[i] = ' ';
                    }
                    ban--;
                }
            }
            if (r == 0) {
                return "Dire";
            } else if (d == 0) {
                return "Radiant";
            }
        }
        return "";
    }
}
