/*
 * Problem: 904. Fruit Into Baskets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fruit-into-baskets/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int totalFruit(int[] fruits) {
        int[] a = { -1, -1 };
        int[] b = { -1, -1 };
        int j = 0;
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == a[0]) {
                a[1] = i;
            } else if (fruits[i] == b[0]) {
                b[1] = i;
            } else {
                if (a[1] > b[1]) {
                    b[0] = fruits[i];
                    j = b[1] + 1;
                    b[1] = i;
                } else {
                    a[0] = fruits[i];
                    j = a[1] + 1;
                    a[1] = i;
                }
            }
            res = Math.max(i - j, res);
        }
        return res + 1;
    }
}
