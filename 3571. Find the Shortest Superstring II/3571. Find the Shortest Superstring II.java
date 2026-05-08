/*
 * Problem: 3571. Find the Shortest Superstring II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-shortest-superstring-ii/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String shortestSuperstring(String s1, String s2) {
        if (s1.contains(s2))
            return s1;
        if (s2.contains(s1))
            return s2;
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        String a = getMin(chrs1, chrs2);
        String b = getMin(chrs2, chrs1);
        if (a == null && b == null)
            return new StringBuilder(s1).append(s2).toString();
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.contains(b))
            return a;
        return b;
    }

    public String getMin(char[] chrs1, char[] chrs2) {
        for (int i = 0; i < chrs1.length; i++) {
            int idx1 = i;
            int idx2 = 0;
            while (idx1 < chrs1.length && idx2 < chrs2.length && chrs1[idx1] == chrs2[idx2]) {
                idx1++;
                idx2++;
            }
            if (idx1 == chrs1.length || idx2 == chrs2.length) {
                StringBuilder SB = new StringBuilder(new String(chrs1));
                while (idx2 < chrs2.length) {
                    SB.append(chrs2[idx2++]);
                }
                return SB.toString();
            }
        }
        return null;
    }
}
