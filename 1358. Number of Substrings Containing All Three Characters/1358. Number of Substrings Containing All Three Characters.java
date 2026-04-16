/*
 * Problem: 1358. Number of Substrings Containing All Three Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int numberOfSubstrings(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[3];
        int count = 0;
        int j = 0;
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (j < chrs.length && count != 3) {
                if (counts[chrs[j] - 'a']++ == 0)
                    count++;
                j++;
            }
            if (count != 3)
                break;
            res += chrs.length - j + 1;
            if (counts[chrs[i] - 'a']-- == 1)
                count--;
        }
        return res;
    }
}
