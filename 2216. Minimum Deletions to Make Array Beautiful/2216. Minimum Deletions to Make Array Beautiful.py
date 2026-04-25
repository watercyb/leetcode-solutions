#
# Problem: 2216. Minimum Deletions to Make Array Beautiful
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
# Language: python3
# Date: 2026-04-25


class Solution:
    def minDeletion(self, nums: List[int]) -> int:
        it = iter(nums)
        res = 0
        for num in it:
            for num_next in it:
                if num != num_next:
                    break
                else:
                    res += 1
            else:
                res += 1
        return res

