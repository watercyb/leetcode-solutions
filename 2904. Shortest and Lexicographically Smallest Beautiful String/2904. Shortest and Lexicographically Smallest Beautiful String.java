/*
 * Problem: 2904. Shortest and Lexicographically Smallest Beautiful String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] chrs = s.toCharArray();
        int j = 0;
        int l = -1;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && k > 0) {
                if (chrs[j] == '1')
                    k--;
                j++;
            }
            if (k > 0)
                break;
            if (chrs[i] == '0')
                continue;
            if (j - i < len) {
                l = i;
                len = j - i;
            } else if (j - i == len) {
                for (int r = 0; r < len; r++) {
                    if (chrs[i + r] < chrs[l + r]) {
                        l = i;
                        len = j - i;
                        break;
                    } else if (chrs[i + r] > chrs[l + r]) {
                        break;
                    }
                }
            }
            k++;
        }
        if (l == -1)
            return "";
        return new String(chrs, l, len);
    }
}
