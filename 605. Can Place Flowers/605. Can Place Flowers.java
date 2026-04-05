/*
 * Problem: 605. Can Place Flowers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/can-place-flowers/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] prv = { 0, flowerbed[0] };
        for (int i = 1; i < flowerbed.length; i++) {
            if (flowerbed[i] + prv[0] + prv[1] == 0) {
                n--;
                if (n <= 0)
                    return true;
                prv[0] = 1;
                prv[1] = 0;
            } else {
                prv[0] = prv[1];
                prv[1] = flowerbed[i];
            }
        }
        if (prv[0] + prv[1] == 0)
            n--;
        return n <= 0;
    }
}
