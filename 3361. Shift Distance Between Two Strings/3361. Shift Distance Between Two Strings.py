#
# Problem: 3361. Shift Distance Between Two Strings
# Difficulty: Medium
# Link: https://leetcode.com/problems/shift-distance-between-two-strings/
# Language: python3
# Date: 2026-05-06


class Solution:
    def shiftDistance(
        self, s: str, t: str, nextCost: List[int], previousCost: List[int]
    ) -> int:
        steps = [[10000000000] * 26 for _ in range(26)]
        for i in range(26):
            stp_next = 0
            stp_prv = 0
            for j in range(26):
                idx_next = (i + j) % 26
                idx_prv = (i - j + 26) % 26
                steps[i][idx_next] = min(steps[i][idx_next], stp_next)
                steps[i][idx_prv] = min(steps[i][idx_prv], stp_prv)
                stp_next += nextCost[idx_next]
                stp_prv += previousCost[idx_prv]
        res = 0
        for i in range(len(s)):
            a = ord(s[i]) - ord("a")
            b = ord(t[i]) - ord("a")
            res += steps[a][b]
        return res

