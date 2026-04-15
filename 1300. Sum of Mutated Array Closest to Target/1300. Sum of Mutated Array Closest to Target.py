#
# Problem: 1300. Sum of Mutated Array Closest to Target
# Difficulty: Medium
# Link: https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
# Language: python3
# Date: 2026-04-15


class Solution:
    def findBestValue(self, arr: List[int], target: int) -> int:
        num_sum = sum(arr)
        if num_sum <= target:
            return max(arr)
        arr.append(0)
        arr.sort()
        num_sum = 0
        for i in range(len(arr)):
            num_sum += arr[i]
            if num_sum + (len(arr) - 1 - i) * arr[i] > target:
                break
        length = len(arr) - i
        diff = target - num_sum + arr[i]
        res = diff // length
        if (2 * res + 1) * length >= 2 * diff:
            return res
        else:
            return res + 1

