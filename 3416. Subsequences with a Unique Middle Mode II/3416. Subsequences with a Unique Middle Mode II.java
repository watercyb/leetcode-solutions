/*
 * Problem: 3416. Subsequences with a Unique Middle Mode II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int subsequencesWithMiddleMode(int[] nums) {
        final int mod = 1_000_000_007;

        HashMap<Integer, Integer> lefts = new HashMap<>(nums.length, 0.99f);
        for (int i = 0; i < nums.length - 2; i++) {
            lefts.put(nums[i], lefts.getOrDefault(nums[i], 0) + 1);
        }

        HashMap<Integer, Integer> rights = new HashMap<>(nums.length, 0.99f);
        long l2 = 0;
        for (long count : lefts.values()) {
            l2 = (l2 + (count * (count - 1) / 2) % mod) % mod;
        }

        long r2 = 0, l1r1 = 0, l2r1 = 0, l1r2 = 0;
        int leftCount = lefts.getOrDefault(nums[nums.length - 1], 0);
        rights.put(nums[nums.length - 1], 1);
        l1r1 = leftCount;
        l2r1 = (long) leftCount * (leftCount - 1) / 2 % mod;

        leftCount = lefts.getOrDefault(nums[nums.length - 2], 0);
        int rightCount = rights.getOrDefault(nums[nums.length - 2], 0) + 1;
        rights.put(nums[nums.length - 2], rightCount);
        r2 = (long) rightCount * (rightCount - 1) / 2 % mod;

        l1r1 = (l1r1 + leftCount) % mod;
        l2r1 = (l2r1 + (long) leftCount * (leftCount - 1) / 2 % mod) % mod;
        l1r2 = (l1r2 + (long) leftCount * ((long) rightCount * (rightCount - 1) / 2 % mod) % mod) % mod;

        long res = 0;

        for (int i = nums.length - 3; i >= 2; i--) {
            long left = lefts.get(nums[i]) - 1;
            long right = rights.getOrDefault(nums[i], 0);

            lefts.put(nums[i], (int) left);
            rights.put(nums[i], (int) right + 1);

            long leftSum = i;
            long rightSum = nums.length - i - 1;

            long a = (left + 1) * left / 2 % mod;
            long b = right * (right - 1) / 2 % mod;
            l2 = (l2 - a + mod) % mod;
            r2 = (r2 - b + mod) % mod;
            l1r1 = (l1r1 - (left + 1) * right % mod + mod) % mod;
            l2r1 = (l2r1 - a * right % mod + mod) % mod;
            l1r2 = (l1r2 - (left + 1) * b % mod + mod) % mod;

            res = (res + ((leftSum * (leftSum - 1) / 2 % mod) * (rightSum * (rightSum - 1) / 2 % mod)) % mod
                    - ((leftSum - left) * (leftSum - left - 1) / 2 % mod)
                            * ((rightSum - right) * (rightSum - right - 1) / 2 % mod) % mod
                    - l2 * right % mod * (rightSum - right) % mod
                    - r2 * left % mod * (leftSum - left) % mod
                    - l1r1 * left % mod * (rightSum - right - 1) % mod
                    - l1r1 * right % mod * (leftSum - left - 1) % mod
                    + (l2r1 * right + l1r2 * left) * 2 % mod) % mod;

            a = (left - 1) * left / 2 % mod;
            b = right * (right + 1) / 2 % mod;
            l2 = (l2 + a) % mod;
            r2 = (r2 + b) % mod;
            l1r1 = (l1r1 + (left * (right + 1) % mod)) % mod;
            l2r1 = (l2r1 + a * (right + 1) % mod) % mod;
            l1r2 = (l1r2 + (left * b % mod)) % mod;
        }

        return (int) ((res + mod) % mod);
    }
}

