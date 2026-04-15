#
# Problem: 1234. Replace the Substring for Balanced String
# Difficulty: Medium
# Link: https://leetcode.com/problems/replace-the-substring-for-balanced-string/
# Language: python3
# Date: 2026-04-15


class Solution:
    def balancedString(self, s: str) -> int:
        counts = Counter(s)
        q = counts["Q"]
        w = counts["W"]
        e = counts["E"]
        r = counts["R"]
        j = 0
        target = len(s) // 4
        res = 10000000
        for i in range(len(s)):
            while j < len(s) and (q > target or w > target or e > target or r > target):
                if s[j] == "Q":
                    q -= 1
                elif s[j] == "W":
                    w -= 1
                elif s[j] == "E":
                    e -= 1
                else:
                    r -= 1
                j += 1
            if (
                q <= target
                and w <= target
                and e <= target
                and r <= target
                and j - i < res
            ):
                res = j - i
                if res == 0:
                    break
            if s[i] == "Q":
                q += 1
            elif s[i] == "W":
                w += 1
            elif s[i] == "E":
                e += 1
            else:
                r += 1
        return res

