#
# Problem: 2998. Minimum Number of Operations to Make X and Y Equal
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
# Language: python3
# Date: 2026-05-02


class Solution:
    def minimumOperationsToMakeEqual(self, x: int, y: int) -> int:
        def dfs(num: int) -> int:
            if num <= y:
                return y - num
            return min(
                num - y,
                dfs(num // 11) + num % 11 + 1,
                dfs(num // 5) + num % 5 + 1,
                dfs(num // 11 + 1) + 11 - num % 11 + 1,
                dfs(num // 5 + 1) + 5 - num % 5 + 1,
            )

        return dfs(x)

