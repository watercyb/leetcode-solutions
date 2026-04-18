#
# Problem: 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
# Language: python3
# Date: 2026-04-18


class Solution:
    def maxNonOverlapping(self, nums: List[int], target: int) -> int:
        num_set = {0}
        num_sum = 0
        res = 0
        for num in nums:
            num_sum += num
            if num_sum - target in num_set:
                res += 1
                num_set.clear()
            num_set.add(num_sum)
        return res

