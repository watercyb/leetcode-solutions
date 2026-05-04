/*
 * Problem: 3147. Taking Maximum Energy From the Mystic Dungeon
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int sum = Integer.MIN_VALUE;
            for (int j = i; j < energy.length; j += k) {
                if (sum < 0)
                    sum = 0;
                sum += energy[j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
