/*
 * Problem: 1256. Encode Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/encode-number/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
