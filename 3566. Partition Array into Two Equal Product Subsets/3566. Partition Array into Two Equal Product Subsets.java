/*
 * Problem: 3566. Partition Array into Two Equal Product Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-array-into-two-equal-product-subsets/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long a = target;
        long b = target;
        boolean usedBoth = false;
        for (int num : nums) {
            if (a % num != 0) {
                if (b % num != 0) {
                    usedBoth = true;
                    long gcd = GCD(a, num);
                    a /= gcd;
                    num /= gcd;
                    gcd = GCD(b, num);
                    b /= gcd;
                    num /= gcd;
                    if (num != 1)
                        return false;
                } else {
                    b /= num;
                }
            } else {
                a /= num;
            }
        }
        if (a != 1 || b != 1)
            return false;
        if (!usedBoth)
            return true;
        return dfs(nums, 0, 1, 1, target);
    }

    public long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    public boolean dfs(int[] nums, int i, long p1, long p2, long target) {
        if (p1 == target && p2 == target && i == nums.length)
            return true;
        if (p1 > target || p2 > target || i == nums.length)
            return false;
        return dfs(nums, i + 1, p1 * nums[i], p2, target)
                || dfs(nums, i + 1, p1, p2 * nums[i], target);
    }
}
