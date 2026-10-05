#
# Problem: Unknown Problem
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-alternating-subarray-sum-with-one-deletion/
# Language: python3
# Date: 2026-10-05


class Solution:
    def maxAlternatingSum(self, nums: list[int]) -> int:
        n = len(nums)
        lefts_reg = [0] * n
        lefts_rev = [0] * n
        dp = [-10000000, 0]
        num_sum = 0
        sign = 1
        res = -100000000000
        for i in range(n):
            num_sum += sign * nums[i]
            if sign == 1:
                reg = num_sum - dp[1]
                rev = dp[0] - num_sum
                lefts_reg[i] = reg
                lefts_rev[i] = rev
                res = max(res, reg, rev)
                dp[0] = max(dp[0], num_sum)
                sign = -1
            else:
                reg = dp[0] - num_sum
                rev = num_sum - dp[1]
                lefts_reg[i] = reg
                lefts_rev[i] = rev
                res = max(res, reg, rev)
                dp[1] = min(dp[1], num_sum)
                sign = 1
        sign = 1
        dp = [0, 0]
        num_sum = 0
        for i in range(n - 1, 1, -1):
            num_sum += sign * nums[i]
            if sign == 1:
                reg = num_sum - dp[0]
                rev = dp[1] - num_sum
                res = max(res, lefts_reg[i - 2] + rev, lefts_rev[i - 2] + reg)
                sign = -1
            else:
                reg = dp[1] - num_sum
                rev = num_sum - dp[0]
                res = max(res, lefts_reg[i - 2] + rev, lefts_rev[i - 2] + reg)
                sign = 1
            dp[0] = min(dp[0], num_sum)
            dp[1] = max(dp[1], num_sum)
        return res

