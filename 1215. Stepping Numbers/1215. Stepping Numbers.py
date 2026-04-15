#
# Problem: 1215. Stepping Numbers
# Difficulty: Medium
# Link: https://leetcode.com/problems/stepping-numbers/
# Language: python3
# Date: 2026-04-15


class Solution:
    def countSteppingNumbers(self, low: int, high: int) -> List[int]:
        res = []

        def dfs(num: int, prv: int):
            if num > high:
                return
            if num >= low:
                res.append(num)
            if prv > 0:
                dfs(num * 10 + prv - 1, prv - 1)
            if prv < 9:
                dfs(num * 10 + prv + 1, prv + 1)

        for i in range(1, 10):
            dfs(i, i)
        if low == 0:
            res.append(0)
        return sorted(res)

