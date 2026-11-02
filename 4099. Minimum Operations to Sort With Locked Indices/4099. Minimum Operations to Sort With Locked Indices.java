/*
 * Problem: 4099. Minimum Operations to Sort With Locked Indices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-sort-with-locked-indices/
 * Language: java
 * Date: 2026-11-02
 */

class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (locked[i] == 1 && (nums[i] != i + 1 || max > nums[i]))
                count++;
            max = Math.max(max, nums[i]);
            nums[i]--;
        }
        if (count > k)
            return -1;
        BIT = new int[nums.length + 1];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[nums[i]] = i;
        }
        int res = count;
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = indexes[i];
            int realIdx = idx + get(idx);
            if (realIdx != i) {
                res += i - realIdx;
                insert(idx + 1, -1);
            }
        }
        return res;
    }

    int[] BIT;

    public void insert(int i, int n) {
        i++;
        while (i < BIT.length) {
            BIT[i] += n;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
