/*
 * Problem: 2262. Total Appeal of A String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/total-appeal-of-a-string/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long appealSum(String s) {
        char[] chrs = s.toCharArray();
        int[] pos = new int['z' + 1];
        Arrays.fill(pos, -1);
        long res = 0;
        for (int i = 0; i < chrs.length; i++) {
            res += (i - pos[chrs[i]]) * (chrs.length - i);
            pos[chrs[i]] = i;
        }
        return res;
    }
}
