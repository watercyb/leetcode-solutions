/*
 * Problem: 2300. Successful Pairs of Spells and Potions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int max = 0;
        for (int potion : potions) {
            max = Math.max(potion, max);
        }
        int[] counts = new int[max + 1];
        for (int potion : potions) {
            counts[potion]++;
        }
        for (int i = max - 1; i >= 0; i--) {
            counts[i] += counts[i + 1];
        }
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
            if (need > max) {
                res[i] = 0;
            } else {
                res[i] = counts[(int) need];
            }
        }
        return res;
    }
}
