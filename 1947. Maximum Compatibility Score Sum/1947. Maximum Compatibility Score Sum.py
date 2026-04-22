#
# Problem: 1947. Maximum Compatibility Score Sum
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximum-compatibility-score-sum/
# Language: python3
# Date: 2026-04-22


class Solution:
    def maxCompatibilitySum(
        self, students: List[List[int]], mentors: List[List[int]]
    ) -> int:
        st = []
        me = []
        for i in range(len(students)):
            h = 0
            for num in students[i]:
                h = h * 2 + num
            st.append(h)
            h = 0
            for num in mentors[i]:
                h = h * 2 + num
            me.append(h)
        meme = [0] * (1 << len(students))

        def dfs(i: int, h: int) -> int:
            if i == len(students):
                return 0
            if meme[h] != 0:
                return meme[h]
            res = 10000000
            for j in range(len(students)):
                h_next = 1 << j
                if (h & h_next) == 0:
                    res = min(res, dfs(i + 1, h + h_next) + (st[i] ^ me[j]).bit_count())
            meme[h] = res
            return res

        return len(students) * len(students[0]) - dfs(0, 0)

