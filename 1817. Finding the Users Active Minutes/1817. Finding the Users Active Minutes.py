#
# Problem: 1817. Finding the Users Active Minutes
# Difficulty: Medium
# Link: https://leetcode.com/problems/finding-the-users-active-minutes/
# Language: python3
# Date: 2026-04-21


class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        mp = {}
        for log in logs:
            u = log[0]
            v = log[1]
            if u not in mp:
                st = set()
                st.add(v)
                mp[u] = st
            else:
                mp[u].add(v)
        res = [0] * k
        for u, v in mp.items():
            res[len(v) - 1] += 1
        return res

