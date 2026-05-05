#
# Problem: 3211. Generate Binary Strings Without Adjacent Zeros
# Difficulty: Medium
# Link: https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/
# Language: python3
# Date: 2026-05-05


class Solution:
    def validStrings(self, n: int) -> List[str]:
        res = []

        def dfs(st: str, prv: int, i: int, n: int):
            if i == n:
                res.append(st)
            elif prv == 1:
                dfs(st + "0", 0, i + 1, n)
                dfs(st + "1", 1, i + 1, n)
            else:
                dfs(st + "1", 1, i + 1, n)

        dfs("", 1, 0, n)
        return res

