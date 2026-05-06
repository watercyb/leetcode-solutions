#
# Problem: 3376. Minimum Time to Break Locks I
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-time-to-break-locks-i/
# Language: python3
# Date: 2026-05-06


class Solution:
    def findMinimumTime(self, strength: List[int], k: int) -> int:
        strength.sort()
        res = 1000000000000
        mp = {}

        def dfs(strength: List[int], n: int, h: int, x: int, k: int, sm: int):
            nonlocal res
            if sm >= res or sm >= mp.get(h, res):
                return
            mp[h] = sm
            if n == len(strength):
                res = sm
            else:
                for i in range(len(strength)):
                    if strength[i] > 0:
                        stp = (strength[i] + x - 1) // x
                        strength[i] = -strength[i]
                        dfs(strength, n + 1, h + (1 << i), x + k, k, sm + stp)
                        strength[i] = -strength[i]
                        if stp == 1:
                            break

        dfs(strength, 0, 0, 1, k, 0)
        return res

