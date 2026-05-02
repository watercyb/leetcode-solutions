/*
 * Problem: 2938. Separate Black and White Balls
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/separate-black-and-white-balls/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '0') {
                res += j - i;
                i++;
            }
        }
        return res;
    }
}
