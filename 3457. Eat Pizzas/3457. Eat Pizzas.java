/*
 * Problem: 3457. Eat Pizzas!
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/eat-pizzas/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxWeight(int[] pizzas) {
        int max = 0;
        for (int pizza : pizzas) {
            max = Math.max(pizza, max);
        }
        int[] counts = new int[max + 1];
        for (int pizza : pizzas) {
            counts[pizza]++;
        }
        long res = 0;
        int len = pizzas.length / 4;
        int idx = max;
        int count = (len + 1) / 2;
        while (count > 0) {
            if (counts[idx] > 0) {
                counts[idx]--;
                res += idx;
                count--;
            } else {
                idx--;
            }
        }
        count = len / 2;
        boolean needs = false;
        while (count > 0) {
            if (counts[idx] > 0) {
                counts[idx]--;
                if (needs) {
                    res += idx;
                    count--;
                }
                needs = !needs;
            } else {
                idx--;
            }
        }
        return res;
    }
}
