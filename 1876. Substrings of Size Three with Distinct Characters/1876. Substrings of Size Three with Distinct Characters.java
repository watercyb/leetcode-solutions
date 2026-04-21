/*
 * Problem: 1876. Substrings of Size Three with Distinct Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3)
            return 0;
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            if (counts[chrs[i]]++ == 1)
                count++;
        }
        int res = 0;
        if (count == 0)
            res = 1;
        for (int i = 3; i < chrs.length; i++) {
            if (counts[chrs[i]]++ == 1)
                count++;
            if (counts[chrs[i - 3]]-- == 2)
                count--;
            if (count == 0)
                res++;
        }
        return res;
    }
}
