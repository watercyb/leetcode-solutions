/*
 * Problem: 767. Reorganize String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reorganize-string/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String reorganizeString(String s) {
        int[] counts = new int['z' + 1];
        char max = 0;
        for (char chr : s.toCharArray()) {
            counts[chr]++;
            if (counts[chr] > counts[max])
                max = chr;
        }
        if (counts[max] > (s.length() + 1) / 2)
            return "";
        char[] chrs = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < counts[max]; i++) {
            chrs[idx] = max;
            idx += 2;
        }
        counts[max] = 0;
        if (idx >= chrs.length)
            idx = 1;
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < counts[i]; j++) {
                chrs[idx] = i;
                idx += 2;
                if (idx >= chrs.length)
                    idx = 1;
            }
        }
        return new String(chrs);
    }
}
