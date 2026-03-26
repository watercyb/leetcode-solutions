/*
 * Problem: 171. Excel Sheet Column Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/excel-sheet-column-number/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        int diff='A'-1;
        for (char chr:columnTitle.toCharArray()) {
            res*=26;
            res+=chr-diff;
        }
        return res;
    }
}
