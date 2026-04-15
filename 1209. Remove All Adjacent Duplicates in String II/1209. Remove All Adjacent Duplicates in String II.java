/*
 * Problem: 1209. Remove All Adjacent Duplicates in String II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] chrs = s.toCharArray();
        int i = 0;
        int l = -1;
        for (int j = 1; j < chrs.length; j++) {
            if (l > i)
                l = i;
            if (i >= 0 && chrs[j] == chrs[i]) {
                chrs[++i] = chrs[j];
                while (l >= 0 && chrs[l] == chrs[i]) {
                    l--;
                }
                if (i - l == k)
                    i = l;
            } else {
                while (l >= 0 && chrs[l] == chrs[i]) {
                    l--;
                }
                if (i - l >= k) {
                    i = l + 1;
                    chrs[i] = chrs[j];
                } else {
                    chrs[++i] = chrs[j];
                    l = i;
                }
            }
        }
        while (l >= 0 && chrs[l] == chrs[i]) {
            l--;
        }
        if (i - l >= k)
            i = l;
        return new String(chrs, 0, i + 1);
    }
}
