#
# Problem: 2933. High-Access Employees
# Difficulty: Medium
# Link: https://leetcode.com/problems/high-access-employees/
# Language: python3
# Date: 2026-05-02


class Solution:
    def findHighAccessEmployees(self, access_times: List[List[str]]) -> List[str]:
        def getTime(st: str) -> int:
            return (
                (ord(st[0]) - ord("0")) * 600
                + (ord(st[1]) - ord("0")) * 60
                + (ord(st[2]) - ord("0")) * 10
                + (ord(st[3]) - ord("0"))
            )

        mp = {}
        for li in access_times:
            if li[0] not in mp:
                mp[li[0]] = [getTime(li[1])]
            else:
                mp[li[0]].append(getTime(li[1]))
        res = []
        for k, v in mp.items():
            v.sort()
            for i in range(len(v) - 2):
                if v[i + 2] - v[i] < 60:
                    res.append(k)
                    break
        return res

