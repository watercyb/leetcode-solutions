/*
 * Problem: 467. Unique Substrings in Wraparound String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findSubstringInWraproundString(String s) {
        char[] chrs = s.toCharArray();
        int[] lens = new int[26];
        int l = 0;
        int r = 0;
        while (r < chrs.length) {
            while (r < chrs.length - 1 && (chrs[r] + 1 == chrs[r + 1] || (chrs[r] == 'z' && chrs[r + 1] == 'a'))) {
                r++;
            }
            while (l <= r) {
                lens[chrs[l] - 'a'] = Math.max(lens[chrs[l] - 'a'], r - l + 1);
                l++;
            }
            r++;
        }
        int res = 0;
        for (int len : lens) {
            res += len;
        }
        return res;
    }
}
