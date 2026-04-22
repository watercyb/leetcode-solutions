/*
 * Problem: 1980. Find Unique Binary String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-unique-binary-string/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                SB.append('1');
            } else {
                SB.append('0');
            }
        }
        return SB.toString();
    }
}
