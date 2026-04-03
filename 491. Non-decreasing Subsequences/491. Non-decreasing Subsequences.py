#
# Problem: 491. Non-decreasing Subsequences
# Difficulty: Medium
# Link: https://leetcode.com/problems/non-decreasing-subsequences/
# Language: python3
# Date: 2026-04-03


class Solution:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        res = []
        num_list = []

        def dfs(i: int, prv: int):
            seens = set()
            while i < len(nums):
                if nums[i] not in seens and prv <= nums[i]:
                    seens.add(nums[i])
                    num_list.append(nums[i])
                    res.append(num_list.copy())
                    dfs(i + 1, nums[i])
                    num_list.pop(-1)
                i += 1

        
        seens = set()
        for i in range(len(nums) - 1):
            if nums[i] not in seens:
                seens.add(nums[i])
                num_list.append(nums[i])
                dfs(i + 1, nums[i])
                num_list.clear()
        return res

