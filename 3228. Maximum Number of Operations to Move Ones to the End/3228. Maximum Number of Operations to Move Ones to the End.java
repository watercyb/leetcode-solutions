/*
 * Problem: 3228. Maximum Number of Operations to Move Ones to the End
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxOperations(String s) {
        char[] chrs = s.toCharArray();
        int count = 0;
        int res = 0;
        for (int i = 0; i < chrs.length - 1; i++) {
            if (chrs[i] == '1') {
                count++;
                if (chrs[i + 1] == '0')
                    res += count;
            }
        }
        return res;
    }
}
