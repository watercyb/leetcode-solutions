#
# Problem: 2992. Number of Self-Divisible Permutations
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-self-divisible-permutations/
# Language: python3
# Date: 2026-05-02


class Solution:
    def selfDivisiblePermutationCount(self, n: int) -> int:
        divs = [[False] * (n) for _ in range(n)]

        def gcd(a: int, b: int) -> int:
            if b == 0:
                return a
            return gcd(b, a % b)

        for i in range(0, n):
            for j in range(i, n):
                if gcd(i + 1, j + 1) == 1:
                    divs[i][j] = divs[j][i] = True

        @lru_cache(None)
        def dfs(i: int, h: int) -> int:
            if i == n:
                return 1
            res = 0
            for j in range(0, n):
                if h & (1 << j) == 0 and divs[i][j]:
                    res += dfs(i + 1, h + (1 << j))
            return res

        return dfs(0, 0)

