/*
 * Problem: 2663. Lexicographically Smallest Beautiful String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-smallest-beautiful-string/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public String smallestBeautifulString(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] first = getFirst(chrs, k);
        if (first == null)
            return "";
        chrs[first[0]] = (char) first[1];
        for (int i = first[0] + 1; i < chrs.length; i++) {
            for (int j = 'a'; j < 'a' + k; j++) {
                if (chk(chrs, i, j)) {
                    chrs[i] = (char) j;
                    break;
                }
            }
        }
        return new String(chrs);
    }

    public int[] getFirst(char[] chrs, int k) {
        for (int i = chrs.length - 1; i >= 0; i--) {
            for (int j = chrs[i] + 1; j < k + 'a'; j++) {
                if (chk(chrs, i, j))
                    return new int[] { i, j };
            }
        }
        return null;
    }

    public boolean chk(char[] chrs, int i, int j) {
        if ((i > 0 && chrs[i - 1] == j) || (i > 1 && chrs[i - 2] == j))
            return false;
        return true;
    }
}
