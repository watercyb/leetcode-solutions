/*
 * Problem: 1668. Maximum Repeating Substring
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-repeating-substring/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxRepeating(String sequence, String word) {
        char[] chrsS = sequence.toCharArray();
        char[] chrsW = word.toCharArray();
        int res = 0;
        for (int i = 0; i <= chrsS.length - chrsW.length; i++) {
            res = Math.max(res, chk(chrsS, chrsW, i));
        }
        return res;
    }

    public int chk(char[] chrsS, char[] chrsW, int i) {
        int res = 0;
        int j = 0;
        while (i < chrsS.length) {
            if (chrsS[i] == chrsW[j]) {
                if (++j == chrsW.length) {
                    j = 0;
                    res++;
                }
            } else {
                break;
            }
            i++;
        }
        return res;
    }
}
