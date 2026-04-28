/*
 * Problem: 2525. Categorize Box According to Criteria
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/categorize-box-according-to-criteria/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long vol = (long) length * width * height;
        int type = 0;
        if (length >= 10_000 || width >= 10_000 || height >= 10_000 || vol >= 1_000_000_000)
            type = 1;
        if (mass >= 100)
            type |= 2;
        switch (type) {
            case 3:
                return "Both";
            case 0:
                return "Neither";
            case 1:
                return "Bulky";
            default:
                return "Heavy";
        }
    }
}
