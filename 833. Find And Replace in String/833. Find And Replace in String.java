/*
 * Problem: 833. Find And Replace in String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-and-replace-in-string/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        char[] chrs = s.toCharArray();
        int[] list = new int[chrs.length];
        Arrays.fill(list, -1);
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i]))
                list[indices[i]] = i;
        }
        int prv = 0;
        StringBuilder SB = new StringBuilder();
        int j = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (list[i] == -1)
                continue;
            while (j < i) {
                SB.append(chrs[j]);
                j++;
            }
            if (i >= prv) {
                SB.append(targets[list[i]]);
                int l = sources[list[i]].length();
                j += l;
                prv += l;
            }
        }
        while (j < chrs.length) {
            SB.append(chrs[j]);
            j++;
        }
        return SB.toString();
    }
}
