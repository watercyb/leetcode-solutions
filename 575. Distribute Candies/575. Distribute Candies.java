/*
 * Problem: 575. Distribute Candies
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distribute-candies/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] seens = new boolean[200001];
        int res = 0;
        for (int c : candyType) {
            c += 100000;
            if (!seens[c]) {
                seens[c] = true;
                res++;
            }
        }
        return Math.min(res, candyType.length / 2);
    }
}
