/*
 * Problem: 316. Remove Duplicate Letters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-duplicate-letters/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i]]++;
        }
        boolean[] used = new boolean['z' + 1];
        char[] arr = new char[26];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i]]--;
            if (used[chrs[i]])
                continue;
            while (idx > 0 && arr[idx - 1] >= chrs[i] && counts[arr[idx - 1]] > 0) {
                used[arr[idx - 1]] = false;
                idx--;
            }
            used[chrs[i]] = true;
            arr[idx++] = chrs[i];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }
}
