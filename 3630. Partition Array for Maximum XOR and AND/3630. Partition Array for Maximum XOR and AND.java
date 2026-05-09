/*
 * Problem: 3630. Partition Array for Maximum XOR and AND
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/partition-array-for-maximum-xor-and-and/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maximizeXorAndXor(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        int[] lims = new int[nums.length];
        int or = 0;
        long xor = 0;
        long and = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            or |= nums[i];
            lims[i] = or;
            xor ^= nums[i];
            and &= nums[i];
        }
        res = Math.max(xor, and);
        dfs(nums, lims, 1, nums[0], -1, 0);
        dfs(nums, lims, 1, 0, nums[0], 0);
        return res;
    }

    long res = 0;

    public void dfs(int[] nums, int[] lims, int i, long a, long b, long c) {
        if (i == nums.length) {
            if (b < 0) {
                res = Math.max(a + c, res);
            } else {
                res = Math.max(a + b + c, res);
            }
        } else if (b == -1) {
            if ((a | lims[i]) + lims[i] + (c | lims[i]) <= res)
                return;
            dfs(nums, lims, i + 1, a ^ nums[i], b, c);
            dfs(nums, lims, i + 1, a, b, c ^ nums[i]);
            dfs(nums, lims, i + 1, a, nums[i], c);
        } else {
            if ((a | lims[i]) + b + (c | lims[i]) <= res)
                return;
            dfs(nums, lims, i + 1, a ^ nums[i], b, c);
            dfs(nums, lims, i + 1, a, b, c ^ nums[i]);
            dfs(nums, lims, i + 1, a, b & nums[i], c);
        }
    }

    public void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}
