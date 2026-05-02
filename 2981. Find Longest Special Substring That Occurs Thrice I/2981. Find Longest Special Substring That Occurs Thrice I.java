/*
 * Problem: 2981. Find Longest Special Substring That Occurs Thrice I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximumLength(String s) {
        int[][] counts = new int[26][3];
        int prv = s.charAt(0) - 'a';
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            int chr = s.charAt(i) - 'a';
            if (chr != prv) {
                if (count == counts[prv][0]) {
                    counts[prv][1]++;
                } else if (count == counts[prv][0] + 1) {
                    counts[prv][2] = counts[prv][1];
                    counts[prv][1] = 1;
                    counts[prv][0] = count;
                } else if (count == counts[prv][0] - 1) {
                    counts[prv][2]++;
                } else if (count > counts[prv][0] + 1) {
                    counts[prv][2] = 0;
                    counts[prv][1] = 1;
                    counts[prv][0] = count;
                }
                count = 1;
                prv = chr;
            } else {
                count++;
            }
        }
        if (count == counts[prv][0]) {
            counts[prv][1]++;
        } else if (count == counts[prv][0] + 1) {
            counts[prv][2] = counts[prv][1];
            counts[prv][1] = 1;
            counts[prv][0] = count;
        } else if (count == counts[prv][0] - 1) {
            counts[prv][2]++;
        } else if (count > counts[prv][0] + 1) {
            counts[prv][2] = 0;
            counts[prv][1] = 1;
            counts[prv][0] = count;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i][1] >= 3) {
                res = Math.max(counts[i][0], res);
            } else if (counts[i][1] + counts[i][2] >= 2) {
                res = Math.max(counts[i][0] - 1, res);
            } else {
                res = Math.max(counts[i][0] - 2, res);
            }
        }
        if (res == 0)
            return -1;
        return res;
    }
}
