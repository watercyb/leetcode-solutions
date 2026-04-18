#
# Problem: 1573. Number of Ways to Split a String
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-ways-to-split-a-string/
# Language: python3
# Date: 2026-04-18


class Solution:
    def numWays(self, s: str) -> int:
        arr = list(map(lambda ch: ord(ch) - ord("0"), s))
        num_sum = sum(arr)
        if num_sum % 3 != 0:
            return 0
        if num_sum == 0:
            return (len(arr) - 1) * (len(arr) - 2) // 2 % 1_000_000_007
        target = num_sum // 3
        idx = 0
        num_sum = 0
        while num_sum < target:
            num_sum += arr[idx]
            idx += 1
        a = 1
        while arr[idx] == 0:
            a += 1
            idx += 1
        target *= 2
        while num_sum < target:
            num_sum += arr[idx]
            idx += 1
        b = 1
        while arr[idx] == 0:
            b += 1
            idx += 1
        return a * b % 1_000_000_007

