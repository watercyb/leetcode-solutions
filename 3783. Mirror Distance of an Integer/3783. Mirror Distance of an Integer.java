/*
 * Problem: 3783. Mirror Distance of an Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/mirror-distance-of-an-integer/?envType=daily-question&envId=2026-04-18
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int mirrorDistance(int n) {
        int num = n;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return Math.abs(n - rev);
    }
}
