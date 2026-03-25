/*
 * Problem: 5. Longest Palindromic Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String longestPalindrome(String s) {
        char[] chrs = getStr(s);
        int[] sizes = new int[chrs.length];
        int c = -1;
        int r = -1;
        int max = 0;
        int center = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (i < r) {
                int size = Math.min(sizes[2 * c - i], r - i);
                int left = i - size - 1;
                int right = i + size + 1;
                while (left >= 0 && right < chrs.length && chrs[left] == chrs[right]) {
                    left--;
                    right++;
                }
                if (right > r + 1) {
                    r = right - 1;
                    c = i;
                }
                sizes[i] = (right - left - 1) / 2;
            } else {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < chrs.length && chrs[left] == chrs[right]) {
                    left--;
                    right++;
                }
                c = i;
                r = right - 1;
                sizes[i] = (right - left - 1) / 2;
            }
            if (r - c > max) {
                max = r - c;
                center = c;
            }
        }
        return s.substring((center - 1) / 2 - (max - 1) / 2, (center - 1) / 2 - (max - 1) / 2 + max);
    }

    public char[] getStr(String str) {
        char[] res = new char[str.length() * 2 + 1];
        int idx = 1;
        for (char chr : str.toCharArray()) {
            res[idx] = chr;
            idx += 2;
        }
        return res;
    }
}
