#
# Problem: 3930. Power Update After K-th Largest Insertion II
# Difficulty: Hard
# Link: https://leetcode.com/problems/power-update-after-k-th-largest-insertion-ii/
# Language: python3
# Date: 2026-05-13


class Solution:
    def powerUpdate(
        self, nums: list[int], p: int, queries: list[list[int]]
    ) -> list[int]:
        mod = 1_000_000_007

        def pow(a: int, b: int) -> int:
            res = 1
            while b > 0:
                if (b & 1) == 1:
                    res = res * a % mod
                a = a * a % mod
                b >>= 1
            return res

        sl = SortedList(nums)

        res = []
        for query in queries:
            sl.add(query[0])
            p = pow(p, sl[len(sl) - query[1]])
            res.append(p)
        return res

