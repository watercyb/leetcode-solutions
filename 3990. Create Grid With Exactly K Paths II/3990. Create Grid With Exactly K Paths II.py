#
# Problem: 3990. Create Grid With Exactly K Paths II
# Difficulty: Hard
# Link: https://leetcode.com/problems/create-grid-with-exactly-k-paths-ii/
# Language: python3
# Date: 2026-07-13


class Solution:
    def createGrid(self, k: int) -> list[str]:
        chrs = [["#"] * 24 + ['.'] for _ in range(25)]
        for i in range(10):
            chrs[i * 2][i] = "."
            chrs[i * 2][i + 1] = "."
            chrs[i * 2 + 1][i] = "."
            chrs[i * 2 + 1][i + 1] = "."
            if k & (1 << i) != 0:
                for j in range(i + 2, 25):
                    chrs[i * 2][j] = "."
        res = []
        for row in chrs:
            res.append("".join(row))
        return res

