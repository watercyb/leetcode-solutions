/*
 * Problem: 3477. Fruits Into Baskets II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fruits-into-baskets-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            boolean found = false;
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    found = true;
                    break;
                }
            }
            if (!found)
                res++;
        }
        return res;
    }
}
