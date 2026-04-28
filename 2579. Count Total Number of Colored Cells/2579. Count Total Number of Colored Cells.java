/*
 * Problem: 2579. Count Total Number of Colored Cells
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-total-number-of-colored-cells/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long coloredCells(int n) {
        return 2l * n * (n - 1) + 1;
    }
}
