/*
 * Problem: 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char chr : n.toCharArray()) {
            if (chr > max) {
                max = chr;
                if (max=='9') return 9;
            }    
        }
        return max-'0';
    }
}
