/*
 * Problem: 3303. Find the Occurrence of First Almost Equal Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minStartingIndex(String s, String pattern) {
        if (pattern.length() == 1)
            return 0;
        char[] chrsS = s.toCharArray();
        char[] chrsP = pattern.toCharArray();
        int[] countsS = new int['z' + 1];
        int[] countsP = new int['z' + 1];
        for (char chr : chrsP) {
            countsP[chr]++;
        }
        int diff = chrsP.length;
        for (int i = 0; i < chrsP.length; i++) {
            countsS[chrsS[i]]++;
            if (countsS[chrsS[i]] <= countsP[chrsS[i]]) {
                diff--;
            } else {
                diff++;
            }
        }
        if (diff <= 2 && chk(chrsS, chrsP, 0))
            return 0;
        for (int i = chrsP.length; i < chrsS.length; i++) {
            countsS[chrsS[i]]++;
            if (countsS[chrsS[i]] <= countsP[chrsS[i]]) {
                diff--;
            } else {
                diff++;
            }
            int idx = i - chrsP.length;
            countsS[chrsS[idx]]--;
            if (countsS[chrsS[idx]] >= countsP[chrsS[idx]]) {
                diff--;
            } else {
                diff++;
            }
            if (diff <= 2 && chk(chrsS, chrsP, idx + 1))
                return idx + 1;
        }
        return -1;
    }

    public boolean chk(char[] chrsS, char[] chrsP, int i) {
        boolean diff = false;
        int l1 = i;
        int r1 = i + chrsP.length - 1;
        int l2 = 0;
        int r2 = chrsP.length - 1;
        while (l1 < r1) {
            if (chrsS[l1] != chrsP[l2]) {
                if (diff)
                    return false;
                diff = true;
            }
            if (chrsS[r1] != chrsP[r2]) {
                if (diff)
                    return false;
                diff = true;
            }
            l1++;
            l2++;
            r1--;
            r2--;
        }
        if (l1 == r1 && chrsS[l1] != chrsP[l2] && diff)
            return false;
        return true;
    }
}
