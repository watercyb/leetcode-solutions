/*
 * Problem: 3223. Minimum Length of String After Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minimumLength(String s) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int res = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == 0)
                continue;
            res += 2 - (counts[i] & 1);
        }
        return res;
    }
}
