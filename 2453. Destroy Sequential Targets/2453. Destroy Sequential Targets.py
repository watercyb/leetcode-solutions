#
# Problem: 2453. Destroy Sequential Targets
# Difficulty: Medium
# Link: https://leetcode.com/problems/destroy-sequential-targets/
# Language: python3
# Date: 2026-04-27


class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        arr = {}
        idx = {}
        for i in range(len(nums)):
            n = nums[i] % space
            arr[n] = arr.get(n, 0) + 1
            if n not in idx or nums[i] < nums[idx[n]]:
                idx[n] = i
        res = 0
        for i in arr.keys():
            if res not in arr or arr[i] > arr[res] or (
                arr[i] == arr[res] and nums[idx[i]] < nums[idx[res]]
            ):
                res = i
        return nums[idx[res]]

