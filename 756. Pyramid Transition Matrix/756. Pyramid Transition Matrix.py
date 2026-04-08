#
# Problem: 756. Pyramid Transition Matrix
# Difficulty: Medium
# Link: https://leetcode.com/problems/pyramid-transition-matrix/
# Language: python3
# Date: 2026-04-08


class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = {}
        for st in allowed:
            k = st[:2]
            if k in mp:
                mp[k].add(st[2])
            else:
                mp[k] = set(st[2])
        meme = set()

        def dfs(bot: str, next_layer: str, i: int) -> bool:
            if len(bot) == 1:
                return True
            if i >= len(bot):
                if next_layer in meme:
                    return False
                meme.add(next_layer)
                return dfs(next_layer, "", 1)
            k = bot[i - 1 : i + 1]
            if k not in mp:
                return False
            st = mp[k]
            for v in st:
                if dfs(bot, next_layer + v, i + 1):
                    return True
            return False

        return dfs(bottom, "", 1)

