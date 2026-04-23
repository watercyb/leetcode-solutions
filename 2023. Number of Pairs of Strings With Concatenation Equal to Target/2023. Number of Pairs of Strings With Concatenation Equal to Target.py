#
# Problem: 2023. Number of Pairs of Strings With Concatenation Equal to Target
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
# Language: python3
# Date: 2026-04-23


class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        n = len(target)
        lefts = [0] * n
        rights = [0] * n
        res = 0
        for num in nums:
            length = len(num)
            if length >= n:
                continue
            left = 0
            right = 0
            if target.startswith(num):
                res += rights[length]
                left = 1
            if target.endswith(num):
                res += lefts[n - 1 - length]
                right = 1
            lefts[length - 1] += left
            rights[n - length] += right
        return res

