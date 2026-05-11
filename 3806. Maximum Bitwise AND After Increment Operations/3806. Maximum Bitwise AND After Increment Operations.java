/*
 * Problem: 3806. Maximum Bitwise AND After Increment Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-bitwise-and-after-increment-operations/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        Arrays.sort(nums);
        int len = 31 - Integer.numberOfLeadingZeros(nums[nums.length - 1] + k);
        int res = 0;
        for (int i = len; i >= 0; i--) {
            if (chk(nums, res + (1 << i), k, m))
                res += 1 << i;
        }
        return res;
    }

    public boolean chk(int[] nums, int target, int k, int m) {
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            counts[i] = getCount(nums[i], target);
        }
        Arrays.sort(counts);
        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += counts[i];
        }
        return sum <= k;
    }

    public int getCount(int num, int target) {
        if ((num & target) == target)
            return 0;
        int m = (Integer.highestOneBit((~num) & target) << 1) - 1;
        return (target & m) - (num & m);
    }
}
