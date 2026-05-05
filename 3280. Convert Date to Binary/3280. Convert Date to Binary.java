/*
 * Problem: 3280. Convert Date to Binary
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-date-to-binary/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String convertDateToBinary(String date) {
        return new StringBuilder(Integer.toBinaryString(Integer.parseInt(date.substring(0, 4)))).append('-')
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(5, 7)))).append('-')
                .append(Integer.toBinaryString(Integer.parseInt(date.substring(8, 10)))).toString();
    }
}
