/*
 * Problem: 3431. Minimum Unlocked Indices to Sort Nums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minUnlockedIndices(int[] nums, int[] locked) {
        int l1 = 0;
        while (l1 < nums.length && nums[l1] == 1) {
            l1++;
        }
        int l3 = l1;
        while (l3 < nums.length && nums[l3] != 3) {
            l3++;
        }
        int r3 = nums.length - 1;
        while (r3 >= 0 && nums[r3] == 3) {
            r3--;
        }
        int r1 = r3;
        while (r1 >= 0 && nums[r1] != 1) {
            r1--;
        }
        if (r1 > l3)
            return -1;
        int res = 0;
        for (int i = l1; i < r1; i++) {
            res += locked[i];
        }
        for (int i = l3; i < r3; i++) {
            res += locked[i];
        }
        return res;
    }
}
