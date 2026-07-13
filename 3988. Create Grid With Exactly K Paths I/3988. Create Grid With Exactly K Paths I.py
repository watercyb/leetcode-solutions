#
# Problem: 3988. Create Grid With Exactly K Paths I
# Difficulty: Medium
# Link: https://leetcode.com/problems/create-grid-with-exactly-k-paths-i/
# Language: python3
# Date: 2026-07-13


class Solution:
    def createGrid(self, m: int, n: int, k: int) -> list[str]:
        chrs = [["#"] * n for _ in range(m)]

        def cnt(x: int, y: int):
            for i in range(y, n):
                chrs[x][i] = "."
            for i in range(x, m):
                chrs[i][-1] = "."

        if k == 1:
            cnt(0, 0)
        elif k == 2:
            if m == 1 or n == 1:
                chrs = []
            else:
                chrs[0][0] = chrs[0][1] = chrs[1][0] = chrs[1][1] = "."
                cnt(1, 1)
        elif k == 3:
            if m >= 3 and n >= 2:
                chrs[0][0] = chrs[0][1] = chrs[1][0] = chrs[1][1] = chrs[2][0] = chrs[
                    2
                ][1] = "."
                cnt(2, 1)
            elif m >= 2 and n >= 3:
                chrs[0][0] = chrs[0][1] = chrs[0][2] = chrs[1][0] = chrs[1][1] = chrs[
                    1
                ][2] = "."
                cnt(1, 2)
            else:
                chrs = []
        elif k == 4:
            if m >= 3 and n >= 3:
                chrs[0][0] = chrs[0][1] = chrs[1][0] = chrs[1][1] = chrs[1][2] = chrs[
                    2
                ][1] = chrs[2][2] = "."
                cnt(2, 2)
            elif m >= 4 and n >= 2:
                chrs[0][0] = chrs[0][1] = chrs[1][0] = chrs[1][1] = chrs[2][0] = chrs[
                    2
                ][1] = chrs[3][0] = chrs[3][1] = "."
                cnt(3, 1)
            elif m >= 2 and n >= 4:
                chrs[0][0] = chrs[0][1] = chrs[0][2] = chrs[0][3] = chrs[1][0] = chrs[
                    1
                ][1] = chrs[1][2] = chrs[1][3] = "."
                cnt(1, 3)
            else:
                chrs = []
        return ["".join(row) for row in chrs]

