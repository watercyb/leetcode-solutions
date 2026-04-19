#
# Problem: 1626. Best Team With No Conflicts
# Difficulty: Medium
# Link: https://leetcode.com/problems/best-team-with-no-conflicts/
# Language: python3
# Date: 2026-04-19


class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        tree = [0] * 1002

        def insert(i, val):
            i += 1
            while i < 1002:
                tree[i] = max(tree[i], val)
                i += i & -i

        def get(i) -> int:
            i += 1
            res = 0
            while i > 0:
                res = max(res, tree[i])
                i -= i & -i
            return res

        arr = []
        for i in range(len(scores)):
            arr.append([scores[i], ages[i]])
        arr.sort(key=lambda x: (x[0], x[1]))

        res = 0
        for i in range(len(arr)):
            score = get(arr[i][1]) + arr[i][0]
            insert(arr[i][1], score)
            res = max(score, res)
        return res

