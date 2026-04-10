/*
 * Problem: 942. DI String Match
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/di-string-match/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] diStringMatch(String s) {
        char[] chrs = s.toCharArray();
        int[] res = new int[s.length() + 1];
        int min = 0;
        int max = chrs.length;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[chrs.length] = min;
        return res;
    }
}
