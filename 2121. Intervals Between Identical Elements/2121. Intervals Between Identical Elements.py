#
# Problem: 2121. Intervals Between Identical Elements
# Difficulty: Medium
# Link: https://leetcode.com/problems/intervals-between-identical-elements/
# Language: python3
# Date: 2026-04-24


class Solution:
    def getDistances(self, arr: List[int]) -> List[int]:
        counts = {}
        lasts = {}
        sums = {}
        res = []
        for i in range(len(arr)):
            count = counts.get(arr[i], 0)
            last = lasts.get(arr[i], i)
            sm = sums.get(arr[i], 0)
            sm += count * (i - last)
            counts[arr[i]] = count + 1
            lasts[arr[i]] = i
            sums[arr[i]] = sm
            res.append(sm)
        counts = {}
        lasts = {}
        sums = {}
        for i in range(len(arr) - 1, -1, -1):
            count = counts.get(arr[i], 0)
            last = lasts.get(arr[i], i)
            sm = sums.get(arr[i], 0)
            sm += count * (last - i)
            counts[arr[i]] = count + 1
            lasts[arr[i]] = i
            sums[arr[i]] = sm
            res[i] += sm
        return res

