#
# Problem: 2007. Find Original Array From Doubled Array
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-original-array-from-doubled-array/
# Language: python3
# Date: 2026-04-23


class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        counts = Counter(changed)
        res = []
        if counts[0] % 2 == 1:
            return []
        for _ in range(counts[0] // 2):
            res.append(0)
        for i in range(1, max(changed) + 1):
            idx = i * 2
            if counts[idx] < counts[i]:
                return []
            counts[idx] -= counts[i]
            for _ in range(counts[i]):
                res.append(i)
        return res

