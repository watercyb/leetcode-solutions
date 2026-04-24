/*
 * Problem: 2169. Count Operations to Obtain Zero
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-operations-to-obtain-zero/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                res += num1 / num2;
                num1 %= num2;
            } else {
                res += num2 / num1;
                num2 %= num1;
            }
        }
        return res;
    }
}
