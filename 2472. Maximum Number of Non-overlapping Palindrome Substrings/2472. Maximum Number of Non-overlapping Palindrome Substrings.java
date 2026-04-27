/*
 * Problem: 2472. Maximum Number of Non-overlapping Palindrome Substrings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int maxPalindromes(String s, int k) {
        char[] chrs = s.toCharArray();
        int i = 0;
        int res = 0;
        while (i <= chrs.length - k - 1) {
            if (chk(chrs, i, i + k - 1)) {
                res++;
                i += k;
            } else if (chk(chrs, i, i + k)) {
                res++;
                i += k + 1;
            } else {
                i++;
            }
        }
        if (i == chrs.length - k && chk(chrs, i, i + k - 1))
            res++;
        return res;
    }

    public boolean chk(char[] chrs, int i, int j) {
        while (i < j) {
            if (chrs[i] != chrs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
