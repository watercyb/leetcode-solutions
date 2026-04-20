/*
 * Problem: 1750. Minimum Length of String After Deleting Similar Ends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minimumLength(String s) {
        char[] chrs = s.toCharArray();
        int l = 0;
        int r = chrs.length - 1;
        int res = s.length();
        while (l < r) {
            if (chrs[l] != chrs[r]) {
                return res;
            } else {
                char tmp=chrs[l];
                while (l <= r &&  chrs[l] ==tmp) {
                    l++;
                    res--;
                }
                while (r >= l && chrs[r] == tmp) {
                    r--;
                    res--;
                }
            }
        }
        return Math.max(res,0);
    }
}
