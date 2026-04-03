/*
 * Problem: 492. Construct the Rectangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/construct-the-rectangle/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[] { area / w, w };
    }
}
