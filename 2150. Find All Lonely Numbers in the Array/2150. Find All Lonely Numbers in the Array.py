#
# Problem: 2150. Find All Lonely Numbers in the Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
# Language: python3
# Date: 2026-04-24


class Solution:
    def findLonely(self, nums: List[int]) -> List[int]:
        counts = [0] * (max(nums) + 2)
        for num in nums:
            counts[num] += 1
        res = []
        for num in nums:
            if counts[num] == 1 and counts[num - 1] == 0 and counts[num + 1] == 0:
                res.append(num)
        return res

