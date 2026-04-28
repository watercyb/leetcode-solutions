/*
 * Problem: 2568. Minimum Impossible OR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-impossible-or/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minImpossibleOR(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            if ((num & -num) == num)
                mask |= num;
        }
        for (int i = 0; i <= 30; i++) {
            if ((mask & (1 << i)) == 0)
                return 1 << i;
        }
        return -1;
    }
}
