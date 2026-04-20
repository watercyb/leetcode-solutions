#
# Problem: 1774. Closest Dessert Cost
# Difficulty: Medium
# Link: https://leetcode.com/problems/closest-dessert-cost/
# Language: python3
# Date: 2026-04-20


class Solution:
    def closestCost(
        self, baseCosts: List[int], toppingCosts: List[int], target: int
    ) -> int:
        res = 0
        diff = 100000000
        baseCosts.append(10000000000)
        st = SortedSet(baseCosts)
        seens = set()

        def chk(a: int):
            nonlocal res, diff
            if a < target:
                if target - a < diff or (target - a == diff and a < res):
                    diff = target - a
                    res = a
            elif a > target:
                if a - target < diff or (a - target == diff and a < res):
                    diff = a - target
                    res = a
            else:
                res = a
                diff = 0

        def dfs(i: int, sm: int):
            k = sm * len(toppingCosts) + i
            if k in seens:
                return
            seens.add(k)
            nonlocal diff
            if sm - target >= diff:
                return
            if i == len(toppingCosts):
                a = st.bisect_left(target - sm)
                chk(sm + st[a])
                chk(sm + st[a - 1])
            else:
                dfs(i + 1, sm)
                dfs(i + 1, sm + toppingCosts[i])
                dfs(i + 1, sm + 2 * toppingCosts[i])

        dfs(0, 0)
        return res

