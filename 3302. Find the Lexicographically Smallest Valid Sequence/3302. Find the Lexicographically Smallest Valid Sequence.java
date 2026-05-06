/*
 * Problem: 3302. Find the Lexicographically Smallest Valid Sequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-lexicographically-smallest-valid-sequence/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] chrs1 = word1.toCharArray();
        char[] chrs2 = word2.toCharArray();
        if (chrs2.length == 1)
            return new int[] { 0 };
        int[] rights = new int[word1.length()];
        int i = chrs1.length - 1;
        int j = chrs2.length - 1;
        while (i >= 0 && j >= 0) {
            rights[i] = chrs2.length - 1 - j;
            if (chrs1[i] == chrs2[j])
                j--;
            i--;
        }
        if (j == chrs2.length - 1 || j == -1) {
            return get(chrs1, chrs2, 0);
        } else {
            i = 0;
            j = 0;
            while (i < chrs1.length) {
                if (j + rights[i] + 1 >= chrs2.length)
                    return get(chrs1, chrs2, j);
                if (chrs1[i] == chrs2[j])
                    j++;
                i++;
            }
            return new int[0];
        }
    }

    public int[] get(char[] chrs1, char[] chrs2, int target) {
        int[] res = new int[chrs2.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < chrs1.length && j < chrs2.length) {
            if (chrs1[i] == chrs2[j] || j == target) {
                if (chrs1[i] == chrs2[j] && j == target)
                    target++;
                res[idx++] = i;
                j++;
            }
            i++;
        }
        if (j != chrs2.length)
            return new int[0];
        return res;
    }
}
