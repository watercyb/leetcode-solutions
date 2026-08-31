#
# Problem: 4041. Minimum Operations to Form Subset Sum II
# Difficulty: Hard
# Link: https://leetcode.com/problems/minimum-operations-to-form-subset-sum-ii/
# Language: python3
# Date: 2026-08-31


class Solution:
    def minOperations(self, nums: list[int], sum: int) -> int:
        if sum in nums:
            return 0
        lim = (1 << (sum + 1)) - 1
        dp = {0: 1}
        lists = {}
        for num in nums:
            if num not in lists:
                li = []
                stp = 0
                while num > 0:
                    n = num
                    s = stp
                    while n <= sum:
                        li.append([n, s])
                        n <<= 1
                        s += 1
                    while (num & 1) == 0:
                        num >>= 1
                        stp += 1
                        li.append([num, stp])
                    num >>= 1
                    stp += 1
                lists[num] = li
            dp_next = dp.copy()
            for k, v in dp.items():
                for [n, s] in lists[num]:
                    new_stp = k + s
                    new_vals = (v << n) & lim
                    dp_next[new_stp] = dp_next.get(new_stp, 0) | new_vals
            dp = {}
            seen = 0
            for k in sorted(dp_next):
                v = dp_next[k] & (~seen)
                if v != 0:
                    dp[k] = v
                    seen |= v
                    if seen == lim:
                        break
        res = 10000000
        for k, v in dp.items():
            if (v & (1 << sum)) != 0:
                res = min(res, k)
        if res == 10000000:
            return -1
        return res

