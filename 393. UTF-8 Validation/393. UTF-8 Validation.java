/*
 * Problem: 393. UTF-8 Validation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/utf-8-validation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean validUtf8(int[] data) {
        int idx = 0;
        int count = 0;
        while (idx < data.length) {
            int num = data[idx];
            if (count > 0) {
                if (num >> 6 != 2)
                    return false;
                count--;
            } else if (num >> 5 == 6) {
                count = 1;
            } else if (num >> 4 == 14) {
                count = 2;
            } else if (num >> 3 == 30) {
                count = 3;
            } else if (num >> 7 != 0) {
                return false;
            }
            idx++;
        }
        return count == 0;
    }
}
