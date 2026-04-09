#
# Problem: 816. Ambiguous Coordinates
# Difficulty: Medium
# Link: https://leetcode.com/problems/ambiguous-coordinates/
# Language: python3
# Date: 2026-04-09


class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        res = []
        st = s[1 : len(s) - 1]

        def dfs(s: str) -> List[str]:
            if len(s) == 1:
                return [s]
            if s[0] == "0" and s[-1] == "0":
                return []
            if s[0] == "0":
                return ["0." + s[1:]]
            if s[-1] == "0":
                return [s]
            res = [s]
            for i in range(1, len(s)):
                res.append(s[:i] + "." + s[i:])
            return res

        for i in range(1, len(st)):
            a = dfs(st[:i])
            b = dfs(st[i:])
            for left in a:
                for right in b:
                    res.append("({}, {})".format(left, right))
        return res

