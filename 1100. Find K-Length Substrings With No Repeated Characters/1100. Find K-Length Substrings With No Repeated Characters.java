/*
 * Problem: 1100. Find K-Length Substrings With No Repeated Characters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (k > 26 || s.length() < k)
            return 0;
        char[] chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        int count = 0;
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (counts[chrs[i]]++ == 1)
                count++;
        }
        if (count == 0)
            res++;
        for (int i = k; i < chrs.length; i++) {
            if (counts[chrs[i]]++ == 1)
                count++;
            if (counts[chrs[i - k]]-- == 2)
                count--;
            if (count == 0)
                res++;
        }
        return res;
    }
}
