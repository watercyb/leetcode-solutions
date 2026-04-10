#
# Problem: 967. Numbers With Same Consecutive Differences
# Difficulty: Medium
# Link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
# Language: python3
# Date: 2026-04-10


class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        self.res = []

        def dfs(prv: int, num: int, n: int, k: int):
            if n == 0:
                self.res.append(num)
            else:
                num *= 10
                if prv - k >= 0:
                    dfs(prv - k, num + prv - k, n - 1, k)
                if k != 0 and prv + k < 10:
                    dfs(prv + k, num + prv + k, n - 1, k)

        for i in range(1, 10):
            dfs(i, i, n - 1, k)
        return self.res

