/*
 * Problem: 1062. Longest Repeating Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-repeating-substring/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int longestRepeatingSubstring(String s) {
        String[] strs = new String[s.length()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = s.substring(i);
        }
        sort(strs, 0, strs.length - 1, 0);
        int res = 0;
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i - 1].length() && j < strs[i].length() && strs[i].charAt(j) == strs[i - 1].charAt(j)) {
                j++;
            }
            res = Math.max(j, res);
        }
        return res;
    }

    public void sort(String[] strs, int l, int r, int i) {
        int[] counts = new int[27];
        String[] strsTemp = new String[r - l + 1];
        for (int j = l; j <= r; j++) {
            int idx = i < strs[j].length() ? strs[j].charAt(i) - '`' : 0;
            counts[idx]++;
        }
        for (int j = 1; j <= 26; j++) {
            counts[j] += counts[j - 1];
        }
        int[] left = counts.clone();
        for (int j = r; j >= l; j--) {
            int idx = i < strs[j].length() ? strs[j].charAt(i) - '`' : 0;
            strsTemp[--left[idx]] = strs[j];
        }
        for (int j = l; j <= r; j++) {
            strs[j] = strsTemp[j - l];
        }
        for (int j = 1; j <= 26; j++) {
            if (left[j] < counts[j] - 1) {
                sort(strs, left[j] + l, counts[j] + l - 1, i + 1);
            }
        }
    }
}
