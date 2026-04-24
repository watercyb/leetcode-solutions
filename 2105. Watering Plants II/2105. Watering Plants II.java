/*
 * Problem: 2105. Watering Plants II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/watering-plants-ii/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int l = 0;
        int r = plants.length - 1;
        int cA = capacityA;
        int cB = capacityB;
        int res = 0;
        while (l < r) {
            if (cA < plants[l]) {
                res++;
                cA = capacityA - plants[l];
            } else {
                cA -= plants[l];
            }
            if (cB < plants[r]) {
                res++;
                cB = capacityB - plants[r];
            } else {
                cB -= plants[r];
            }
            l++;
            r--;
        }
        if (l == r) {
            if (cA >= cB) {
                if (cA < plants[l])
                    res++;
            } else {
                if (cB < plants[r])
                    res++;
            }
        }
        return res;
    }
}
