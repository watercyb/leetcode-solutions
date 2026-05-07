/*
 * Problem: 3498. Reverse Degree of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-degree-of-a-string/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        int idx = 1;
        for (char chr : s.toCharArray()) {
            res += ('z' - chr + 1) * idx++;
        }
        return res;
    }
}
