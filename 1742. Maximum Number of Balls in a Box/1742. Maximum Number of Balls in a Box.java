/*
 * Problem: 1742. Maximum Number of Balls in a Box
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-balls-in-a-box/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] counts = new int[46];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            int idx = 0;
            while (num > 0) {
                idx += num % 10;
                num /= 10;
            }
            counts[idx]++;
        }
        for (int count : counts) {
            res = Math.max(count, res);
        }
        return res;
    }
}
