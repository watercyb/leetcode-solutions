/*
 * Problem: 1788. Maximize the Beauty of the Garden
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-the-beauty-of-the-garden/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maximumBeauty(int[] flowers) {
        int[] last = new int[20001];
        int[] sums = new int[flowers.length];
        int sum = 0;
        for (int i = 0; i < flowers.length; i++) {
            last[flowers[i] + 10000] = i;
            sum += Math.max(flowers[i], 0);
            sums[i] = sum;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < flowers.length; i++) {
            if (last[flowers[i] + 10000] != i) {
                res = Math.max(flowers[i] * 2 + sums[last[flowers[i] + 10000] - 1] - sums[i], res);
            }
        }
        return res;
    }
}
