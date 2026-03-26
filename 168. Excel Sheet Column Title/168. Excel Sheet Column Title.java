/*
 * Problem: 168. Excel Sheet Column Title
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/excel-sheet-column-title/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder SB = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int digit = columnNumber % 26;
            SB.append((char) (digit + 'A'));
            columnNumber /= 26;
        }
        return SB.reverse().toString();
    }
}
