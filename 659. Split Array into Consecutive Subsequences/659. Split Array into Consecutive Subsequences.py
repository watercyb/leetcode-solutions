#
# Problem: 659. Split Array into Consecutive Subsequences
# Difficulty: Medium
# Link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
# Language: python3
# Date: 2026-04-06


class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        a = 0
        b = 0
        c = 0
        idx = 0
        prv = -10000000
        while idx < len(nums):
            count = 0
            current = nums[idx]
            while idx < len(nums) and nums[idx] == current:
                count += 1
                idx += 1
            if current == prv + 1:
                if count >= a + b + c:
                    count -= a + b + c
                    c += b
                    b = a
                    a = count
                else:
                    if count < a + b:
                        return False
                    count -= a + b
                    c = count + b
                    b = a
                    a = 0
            else:
                if a + b != 0:
                    return False
                a = count
                b = 0
                c = 0
            prv = current
        return a + b == 0

