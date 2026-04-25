#
# Problem: 2212. Maximum Points in an Archery Competition
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-points-in-an-archery-competition/
# Language: python3
# Date: 2026-04-25


class Solution:
    def maximumBobPoints(self, numArrows: int, aliceArrows: List[int]) -> List[int]:
        res = None
        max_score = 0

        def dfs(arr: List[int], num: int, i: int, score: int):
            nonlocal max_score, res
            if i == len(arr):
                if score > max_score:
                    max_score = score
                    res = arr.copy()
                    res[0] += num
            else:
                arr[i] = 0
                dfs(arr, num, i + 1, score)
                if num > aliceArrows[i]:
                    needs = aliceArrows[i] + 1
                    arr[i] = needs
                    dfs(arr, num - needs, i + 1, score + i)

        dfs([0] * 12, numArrows, 0, 0)
        return res

