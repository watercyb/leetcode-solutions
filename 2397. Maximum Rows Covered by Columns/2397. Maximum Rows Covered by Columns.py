#
# Problem: 2397. Maximum Rows Covered by Columns
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-rows-covered-by-columns/
# Language: python3
# Date: 2026-04-26


class Solution:
    def maximumRows(self, matrix: List[List[int]], numSelect: int) -> int:
        arr = []
        for row in matrix:
            h = 0
            for i in range(len(row)):
                if row[i] == 1:
                    h += 1 << i
            arr.append(h)
        res = 0

        def dfs(h: int, i: int, cnt: int):
            nonlocal res
            if i == len(arr):
                res = max(res, cnt)
            else:
                dfs(h, i + 1, cnt)
                h_next = h | arr[i]
                if h_next.bit_count() <= numSelect:
                    dfs(h_next, i + 1, cnt + 1)

        dfs(0, 0, 0)
        return res

