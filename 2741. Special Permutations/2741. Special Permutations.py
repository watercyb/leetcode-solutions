#
# Problem: 2741. Special Permutations
# Difficulty: Medium
# Link: https://leetcode.com/problems/special-permutations/
# Language: python3
# Date: 2026-04-30


class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        mod = 1_000_000_007
        meme = {}

        def dfs(h: int, prv: int, lim: int) -> int:
            if (h << 4) + prv in meme:
                return meme[(h << 4) + prv]
            if h == 0:
                res = 0
                for i in range(len(nums)):
                    res += dfs(1 << i, i, lim)
                return res % mod
            if h == lim:
                return 1
            res = 0
            for i in range(len(nums)):
                if h & (1 << i) == 0 and (
                    nums[prv] % nums[i] == 0 or nums[i] % nums[prv] == 0
                ):
                    res += dfs(h + (1 << i), i, lim)
            meme[(h << 4) + prv] = res % mod
            return meme[(h << 4) + prv]

        return dfs(0, -1, (1 << len(nums)) - 1)

