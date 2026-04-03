#
# Problem: 522. Longest Uncommon Subsequence II
# Difficulty: Medium
# Link: https://leetcode.com/problems/longest-uncommon-subsequence-ii/
# Language: python3
# Date: 2026-04-03


class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def getLen(i: int, j: int) -> int:
            str_1 = strs[i]
            str_2 = strs[j]
            if str_1 == str_2:
                return len(str_1)
            i = 0
            for chr in str_1:
                if chr == str_2[i]:
                    i += 1
                    if i == len(str_2):
                        return len(str_2)
            return 0

        def chk(i: int) -> int:
            res = len(strs[i])
            for j in range(i + 1, len(strs)):
                if strs[j] == "":
                    continue
                length = getLen(i, j)
                if length == len(strs[i]):
                    res = 0
                if length == len(strs[j]):
                    strs[j] = ""
            return res

        strs.sort(key=lambda x: -len(x))
        for i in range(len(strs)):
            if strs[i] == "":
                continue
            length = chk(i)
            if length > 0:
                return length
        return -1

