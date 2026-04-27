/*
 * Problem: 2405. Optimal Partition of String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/optimal-partition-of-string/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int res = 1;
        for (char chr : s.toCharArray()) {
            if (seen[chr-'a']) {
                res++;
                seen = new boolean[26];
            }
            seen[chr-'a'] = true;
        }
        return res;
    }
}
