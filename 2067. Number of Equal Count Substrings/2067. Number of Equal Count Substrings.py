#
# Problem: 2067. Number of Equal Count Substrings
# Difficulty: Medium
# Link: https://leetcode.com/problems/number-of-equal-count-substrings/
# Language: python3
# Date: 2026-04-23


class Solution:
    def equalCountSubstrings(self, s: str, count: int) -> int:
        res = 0
        for i in range(min(len(s) // count, 26), 0, -1):
            types = 0
            counts = [0] * 26
            cnt = 0
            for j in range(i * count):
                idx = ord(s[j]) - ord("a")
                counts[idx] += 1
                if counts[idx] == 1:
                    types += 1
                if counts[idx] == count:
                    cnt += 1
                elif counts[idx] == count + 1:
                    cnt -= 1
            if types == cnt:
                res += 1
            for j in range(i * count, len(s)):
                idx = ord(s[j]) - ord("a")
                counts[idx] += 1
                if counts[idx] == 1:
                    types += 1
                if counts[idx] == count:
                    cnt += 1
                elif counts[idx] == count + 1:
                    cnt -= 1
                idx = ord(s[j - i * count]) - ord("a")
                counts[idx] -= 1
                if counts[idx] == 0:
                    types -= 1
                if counts[idx] == count:
                    cnt += 1
                elif counts[idx] == count - 1:
                    cnt -= 1
                if types == cnt:
                    res += 1
        return res

