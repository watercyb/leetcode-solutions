#
# Problem: 915. Partition Array into Disjoint Intervals
# Difficulty: Medium
# Link: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
# Language: python3
# Date: 2026-04-10


class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        num_max = nums[0]
        res = 1
        j = 1
        for i in range(1, len(nums)):
            if nums[i] < num_max:
                res = i + 1
                while j <= i:
                    num_max = max(num_max, nums[j])
                    j += 1
        return res

