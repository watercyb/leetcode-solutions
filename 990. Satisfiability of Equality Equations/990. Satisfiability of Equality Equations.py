#
# Problem: 990. Satisfiability of Equality Equations
# Difficulty: Medium
# Link: https://leetcode.com/problems/satisfiability-of-equality-equations/
# Language: python3
# Date: 2026-04-10


class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        def find(i) -> int:
            if links[i] != i:
                links[i] = find(links[i])
            return links[i]

        links = [i for i in range(26)]
        for i in range(len(equations)):
            if equations[i][1] == "=":
                a = find(ord(equations[i][0]) - ord("a"))
                b = find(ord(equations[i][3]) - ord("a"))
                links[a] = b
        for i in range(len(equations)):
            if equations[i][1] == "!":
                a = find(ord(equations[i][0]) - ord("a"))
                b = find(ord(equations[i][3]) - ord("a"))
                if a == b:
                    return False
        return True

