#
# Problem: 672. Bulb Switcher II
# Difficulty: Medium
# Link: https://leetcode.com/problems/bulb-switcher-ii/
# Language: python3
# Date: 2026-04-06


class Solution:
    def flipLights(self, n: int, presses: int) -> int:
        if presses == 0:
            return 1
        if n > 4:
            n = 4
        h = (1 << n) - 1
        mask_1 = h
        mask_2 = 0
        mask_3 = 0
        mask_4 = 0
        for i in range(1, n, 2):
            mask_2 += 1 << i
        for i in range(0, n, 2):
            mask_3 += 1 << i
        for i in range(0, n, 3):
            mask_4 += 1 << i

        def dfs(st: set, h: int, j: int, n: int) -> int:
            if n == 0:
                if h not in st:
                    st.add(h)
                    return 1
                return 0
            if j == 4:
                return 0
            if j == 0:
                return dfs(st, h, j + 1, n) + dfs(st, h ^ mask_1, j + 1, n - 1)
            if j == 1:
                return dfs(st, h, j + 1, n) + dfs(st, h ^ mask_2, j + 1, n - 1)
            if j == 2:
                return dfs(st, h, j + 1, n) + dfs(st, h ^ mask_3, j + 1, n - 1)
            if j == 3:
                return dfs(st, h, j + 1, n) + dfs(st, h ^ mask_4, j + 1, n - 1)

        st = set()
        if presses == 1:
            return dfs(st, 0, 0, 1)
        if presses == 2:
            return dfs(st, 0, 0, 0) + dfs(st, 0, 0, 2)
        if presses % 2 == 1:
            return dfs(st, 0, 0, 1) + dfs(st, 0, 0, 3)
        return dfs(st, 0, 0, 0) + dfs(st, 0, 0, 2) + dfs(st, 0, 0, 4)

