#
# Problem: 3387. Maximize Amount After Two Days of Conversions
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/
# Language: python3
# Date: 2026-05-06


class Solution:
    def maxAmount(
        self,
        initialCurrency: str,
        pairs1: List[List[str]],
        rates1: List[float],
        pairs2: List[List[str]],
        rates2: List[float],
    ) -> float:
        mp = {}
        mp[initialCurrency] = 1
        changed = True
        while changed:
            changed = False
            for i in range(len(pairs1)):
                a = pairs1[i][0]
                b = pairs1[i][1]
                r = rates1[i]
                r_a = mp.get(a, 0)
                r_b = mp.get(b, 0)
                if r_a == 0 and r_b == 0:
                    continue
                if r_b == 0:
                    mp[b] = r_a * r
                    changed = True
                elif r_a == 0:
                    mp[a] = r_b / r
                    changed = True

            for i in range(len(pairs1) - 1, -1, -1):
                a = pairs1[i][0]
                b = pairs1[i][1]
                r = rates1[i]
                r_a = mp.get(a, 0)
                r_b = mp.get(b, 0)
                if r_a == 0 and r_b == 0:
                    continue
                if r_b == 0:
                    mp[b] = r_a * r
                    changed = True
                elif r_a == 0:
                    mp[a] = r_b / r
                    changed = True

        mp1 = {}
        mp1[initialCurrency] = 1
        changed = True
        while changed:
            changed = False
            for i in range(len(pairs2)):
                a = pairs2[i][0]
                b = pairs2[i][1]
                r = rates2[i]
                r_a = mp1.get(a, 0)
                r_b = mp1.get(b, 0)
                if r_a == 0 and r_b == 0:
                    continue
                if r_b == 0:
                    mp1[b] = r_a * r
                    changed = True
                elif r_a == 0:
                    mp1[a] = r_b / r
                    changed = True

            for i in range(len(pairs2) - 1, -1, -1):
                a = pairs2[i][0]
                b = pairs2[i][1]
                r = rates2[i]
                r_a = mp1.get(a, 0)
                r_b = mp1.get(b, 0)
                if r_a == 0 and r_b == 0:
                    continue
                if r_b == 0:
                    mp1[b] = r_a * r
                    changed = True
                elif r_a == 0:
                    mp1[a] = r_b / r
                    changed = True
        res = 1
        for k, v in mp.items():
            if k in mp1:
                res = max(res, mp[k] / mp1[k])
        return res

