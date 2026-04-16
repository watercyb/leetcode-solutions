#
# Problem: 1338. Reduce Array Size to The Half
# Difficulty: Medium
# Link: https://leetcode.com/problems/reduce-array-size-to-the-half/
# Language: python3
# Date: 2026-04-16


class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        counts = Counter(Counter(arr).values())
        counts = sorted(counts.items(), key=lambda x: -x[0])
        length = len(arr)
        res = 0
        for i in range(len(counts)):
            for j in range(counts[i][1]):
                length -= counts[i][0]
                res += 1
                if 2 * length <= len(arr):
                    return res
        return res

