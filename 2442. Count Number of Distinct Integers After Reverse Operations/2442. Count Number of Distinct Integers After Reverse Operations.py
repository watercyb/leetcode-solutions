#
# Problem: 2442. Count Number of Distinct Integers After Reverse Operations
# Difficulty: Medium
# Link: https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
# Language: python3
# Date: 2026-04-27


class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            if nums[i] >= 10:
                nums.append(int(str(nums[i])[::-1]))
        return len(set(nums))

