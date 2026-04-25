/*
 * Problem: 2264. Largest 3-Same-Digit Number in String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public String largestGoodInteger(String num) {
        for (String h : Arrays.asList("999", "888", "777", "666", "555", "444", "333", "222", "111", "000")) {
            if (num.contains(h))
                return h;
        }
        return "";
    }
}
