#
# Problem: 2190. Most Frequent Number Following Key In an Array
# Difficulty: Easy
# Link: https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/
# Language: python3
# Date: 2026-04-24


class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        counts = [0 for _ in range(1001)]
        for i in range(len(nums) - 1):
            if nums[i] == key:
                counts[nums[i + 1]] += 1
        max = 0
        for i in range(1001):
            if counts[i] > counts[max]:
                max = i
        return max

