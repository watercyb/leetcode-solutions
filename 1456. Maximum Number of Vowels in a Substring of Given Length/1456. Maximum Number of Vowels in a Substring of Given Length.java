/*
 * Problem: 1456. Maximum Number of Vowels in a Substring of Given Length
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxVowels(String s, int k) {
        char[] chrs = s.toCharArray();
        int[] vowels = new int['z' + 1];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;
        int res = 0;
        if (chrs.length <= k) {
            for (char chr : chrs) {
                res += vowels[chr];
            }
            return res;
        } else {
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += vowels[chrs[i]];
            }
            res = Math.max(count, res);
            int j = 0;
            for (int i = k; i < chrs.length; i++) {
                count += vowels[chrs[i]] - vowels[chrs[j]];
                res = Math.max(count, res);
                j++;
            }
        }
        return res;
    }
}
