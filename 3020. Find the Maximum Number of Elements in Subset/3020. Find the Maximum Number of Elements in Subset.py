#
# Problem: 3020. Find the Maximum Number of Elements in Subset
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/
# Language: python3
# Date: 2026-05-03


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        counts = Counter(nums)
        arr = list(set(nums))
        arr.sort()
        res = 1
        dp = {}
        if counts[1] > 0:
            res = counts[1] - 1 + counts[1] % 2
        for num in arr:
            length = dp.get(num, 0)
            if counts[num] > 1:
                dp[num * num] = length + 2
                res = max(res, length + 1)
            else:
                res = max(res, length + 1)
        return res

