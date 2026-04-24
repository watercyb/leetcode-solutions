/*
 * Problem: 2172. Maximum AND Sum of Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-and-sum-of-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int l = (int) Math.pow(3, numSlots) - 1;
        return dfs(new int[l + 1], nums, 0, new int[numSlots], l);
    }

    public int dfs(int[] mems, int[] nums, int i, int[] slots, int slot) {
        if (i == nums.length)
            return 0;
        if (mems[slot] != 0)
            return mems[slot];
        int base = 1;
        int res = 0;
        for (int j = 0; j < slots.length; j++) {
            if (slots[j] < 2) {
                slots[j]++;
                res = Math.max(dfs(mems, nums, i + 1, slots, slot - base) + (nums[i] & (j + 1)), res);
                slots[j]--;
            }
            base *= 3;
        }
        mems[slot] = res;
        return res;
    }
}
