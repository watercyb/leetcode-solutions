/*
 * Problem: 3216. Lexicographically Smallest String After a Swap
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String getSmallestString(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length - 1; i++) {
            if (chrs[i] % 2 == chrs[i + 1] % 2 && chrs[i] > chrs[i + 1]) {
                char temp = chrs[i];
                chrs[i] = chrs[i + 1];
                chrs[i + 1] = temp;
                return new String(chrs);
            }
        }
        return s;
    }
}
