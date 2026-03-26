/*
 * Problem: 205. Isomorphic Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/isomorphic-strings/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] chrS = s.toCharArray();
        char[] chrT = t.toCharArray();
        int[] linkS = new int[128];
        int[] linkT = new int[128];
        Arrays.fill(linkS, -1);
        Arrays.fill(linkT, -1);
        for (int i = 0; i < chrS.length; i++) {
            if (linkS[chrS[i]] == -1 && linkT[chrT[i]] == -1) {
                linkS[chrS[i]] = chrT[i];
                linkT[chrT[i]] = chrS[i];
                continue;
            }
            if (linkS[chrS[i]] == chrT[i] && linkT[chrT[i]] == chrS[i])
                continue;
            return false;
        }
        return true;
    }
}
