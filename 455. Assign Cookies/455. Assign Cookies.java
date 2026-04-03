/*
 * Problem: 455. Assign Cookies
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/assign-cookies/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int i=0;
        int j=0;
        while (i<s.length&&j<g.length) {
            if (s[i]>=g[j]) {
                res++;
                j++;
            }
            i++;
        }
        return res;
    }
}
