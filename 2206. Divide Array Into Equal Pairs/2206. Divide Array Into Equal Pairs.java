/*
 * Problem: 2206. Divide Array Into Equal Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/divide-array-into-equal-pairs/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] odds = new boolean[501];
        for (int num : nums) {
            odds[num] = !odds[num];
        }
        for (boolean odd : odds) {
            if (odd)
                return false;
        }
        return true;
    }
}
