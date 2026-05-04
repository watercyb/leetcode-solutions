/*
 * Problem: 3178. Find the Child Who Has the Ball After K Seconds
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int numberOfChild(int n, int k) {
        n--;
        int a = k / n;
        int b = k % n;
        if (a % 2 == 1) {
            return n - b;
        } else {
            return b;
        }
    }
}
