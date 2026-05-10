/*
 * Problem: 3760. Maximum Substrings With Distinct Start
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-substrings-with-distinct-start/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxDistinct(String s) {
        boolean[] seens = new boolean['z' + 1];
        int res = 0;
        for (char chr : s.toCharArray()) {
            if (!seens[chr]) {
                seens[chr] = true;
                if (++res == 26)
                    break;
            }
        }
        return res;
    }
}
