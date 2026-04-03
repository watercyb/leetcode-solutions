#
# Problem: 526. Beautiful Arrangement
# Difficulty: Medium
# Link: https://leetcode.com/problems/beautiful-arrangement/
# Language: python3
# Date: 2026-04-03


class Solution:
    def countArrangement(self, n: int) -> int:
        meme = {}

        def dfs(h: int, i: int, lim: int) -> int:
            if i == lim:
                return 1
            else:
                k = (h << 4) + i
                if k in meme:
                    return meme[k]
                res = 0
                for j in range(1, lim):
                    bi = 1 << (j - 1)
                    if h & bi == 0 and (j % i == 0 or i % j == 0):
                        res += dfs(h + bi, i + 1, lim)
                meme[k] = res
                return res

        return dfs(0, 1, n + 1)

