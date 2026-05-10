/*
 * Problem: 3745. Maximize Expression of Three Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximize-expression-of-three-elements/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
            if (num < c)
                c = num;
        }
        return a + b - c;
    }
}
