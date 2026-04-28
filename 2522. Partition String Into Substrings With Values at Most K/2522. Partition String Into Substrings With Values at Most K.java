/*
 * Problem: 2522. Partition String Into Substrings With Values at Most K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minimumPartition(String s, int k) {
        long num = 0;
        int res = 1;
        for (char chr : s.toCharArray()) {
            int digit = chr - '0';
            num = num * 10 + digit;
            if (num > k) {
                res++;
                num = digit;
                if (digit > k)
                    return -1;
            }
        }
        return res;
    }
}
