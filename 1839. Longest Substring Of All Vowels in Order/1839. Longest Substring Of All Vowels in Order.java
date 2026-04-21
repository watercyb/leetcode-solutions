/*
 * Problem: 1839. Longest Substring Of All Vowels in Order
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int longestBeautifulSubstring(String word) {
        char[] chrs = word.toCharArray();
        int[] vowels = new int['z' + 1];
        vowels['a'] = 1;
        vowels['e'] = 2;
        vowels['i'] = 4;
        vowels['o'] = 8;
        vowels['u'] = 16;
        int prv = 0;
        int res = 0;
        int sum = vowels[chrs[0]];
        for (int i = 1; i < chrs.length; i++) {
            if (chrs[i] < chrs[i - 1]) {
                if (sum == 31)
                    res = Math.max(i - prv, res);
                prv = i;
                sum = vowels[chrs[i]];
            } else {
                sum |= vowels[chrs[i]];
            }
        }
        if (sum == 31)
            res = Math.max(chrs.length - prv, res);
        return res;
    }
}
