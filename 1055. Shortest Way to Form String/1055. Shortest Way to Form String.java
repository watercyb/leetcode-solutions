/*
 * Problem: 1055. Shortest Way to Form String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-way-to-form-string/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int shortestWay(String source, String target) {
        char[] chrs = source.toCharArray();
        int res = 1;
        int j = 0;
        for (int i = 0; i < target.length(); i++) {
            char chr = target.charAt(i);
            int k = j;
            while (k < chrs.length && chrs[k] != chr) {
                k++;
            }
            if (k == chrs.length) {
                res++;
                k = 0;
                while (k < chrs.length && chrs[k] != chr) {
                    k++;
                }
                if (k == chrs.length)
                    return -1;
            }
            j = k + 1;
        }
        return res;
    }
}
