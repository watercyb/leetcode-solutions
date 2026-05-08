/*
 * Problem: 3516. Find Closest Person
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-closest-person/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a < b) {
            return 1;
        } else if (a > b) {
            return 2;
        } else {
            return 0;
        }
    }
}
