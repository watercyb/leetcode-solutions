/*
 * Problem: 1262. Greatest Sum Divisible by Three
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/greatest-sum-divisible-by-three/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int[] a = { Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 };
        int[] b = { Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2 };
        for (int num : nums) {
            if (num < a[1] && num % 3 == 1) {
                if (num < a[0]) {
                    a[1] = a[0];
                    a[0] = num;
                } else {
                    a[1] = num;
                }
            } else if (num < b[1] && num % 3 == 2) {
                if (num < b[0]) {
                    b[1] = b[0];
                    b[0] = num;
                } else {
                    b[1] = num;
                }
            }
            sum += num;
        }
        if (sum % 3 == 0)
            return sum;
        if (sum % 3 == 1) {
            return sum - Math.min(a[0], b[0] + b[1]);
        } else {
            return sum - Math.min(a[0] + a[1], b[0]);
        }
    }
}
