#
# Problem: 2152. Minimum Number of Lines to Cover Points
# Difficulty: Medium
# Link: https://leetcode.com/problems/minimum-number-of-lines-to-cover-points/
# Language: python3
# Date: 2026-04-24


class Solution:
    def minimumLines(self, points: List[List[int]]) -> int:
        n = len(points)
        if n <= 2:
            return 1
        mp = {}
        mp1 = {}
        for i in range(len(points)):
            x1 = points[i][0]
            y1 = points[i][1]
            for j in range(i + 1, n):
                x2 = points[j][0]
                y2 = points[j][1]
                if y1 == y2:
                    mp[y1] = mp.get(y1, 0) | (1 << i) | (1 << j)
                else:
                    sl = (x2 - x1) / (y2 - y1)
                    x = x1 - y1 * sl
                    mp1[(sl, x)] = mp1.get((sl, x), 0) | (1 << i) | (1 << j)
        st = set()
        for _, v in mp.items():
            st.add(v)
        for _, v in mp1.items():
            st.add(v)
        arr = []
        for v in st:
            if v.bit_count() >= 3:
                arr.append(v)
        dp = [10] * (1 << n)
        dp[0] = 0
        res = 10
        for i in range(len(dp)):
            if dp[i] == 10:
                continue
            for v in arr:
                dp[i | v] = min(dp[i | v], dp[i] + 1)
            res = min(res, dp[i] + (n - i.bit_count() + 1) / 2)
        return int(res)

