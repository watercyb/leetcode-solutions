/*
 * Problem: 888. Fair Candy Swap
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/fair-candy-swap/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = 0;
        int sum2 = 0;
        int max1 = 0;
        int max2 = 0;
        for (int num : aliceSizes) {
            sum1 += num;
            max1 = Math.max(num, max1);
        }
        for (int num : bobSizes) {
            sum2 += num;
            max2 = Math.max(num, max2);
        }
        boolean[] seens = new boolean[Math.max(max1, max2) + 1];
        for (int num : bobSizes) {
            seens[num] = true;
        }
        int diff = (sum1 - sum2) / 2;
        for (int num : aliceSizes) {
            int idx = num - diff;
            if (idx >= 0 && idx < seens.length && seens[idx])
                return new int[] { num, idx };
        }
        return new int[] {};
    }
}
