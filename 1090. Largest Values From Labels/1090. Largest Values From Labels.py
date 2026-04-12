#
# Problem: 1090. Largest Values From Labels
# Difficulty: Medium
# Link: https://leetcode.com/problems/largest-values-from-labels/
# Language: python3
# Date: 2026-04-12


class Solution:
    def largestValsFromLabels(
        self, values: List[int], labels: List[int], numWanted: int, useLimit: int
    ) -> int:
        arr = []
        for i in range(len(values)):
            arr.append((values[i], labels[i]))
        arr.sort(key=lambda x: -x[0])
        mp = {}
        res = 0
        for v, l in arr:
            count = mp.get(l, 0)
            if count < useLimit:
                mp[l] = count + 1
                res += v
                numWanted -= 1
                if numWanted == 0:
                    break
        return res

