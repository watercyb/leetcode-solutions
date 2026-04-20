/*
 * Problem: 1739. Building Boxes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/building-boxes/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minimumBoxes(int n) {
        int sum = 0;
        int a = 1;
        int b = 2;
        while (sum + a < n) {
            sum += a;
            a += b;
            b++;
        }
        if (sum + a == n)
            return a;
        sum = n - sum;
        int c = 1;
        while (sum > c) {
            sum -= c;
            c++;
        }
        return a - b + 1 + c;
    }
}
