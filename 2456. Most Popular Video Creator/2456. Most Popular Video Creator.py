#
# Problem: 2456. Most Popular Video Creator
# Difficulty: Medium
# Link: https://leetcode.com/problems/most-popular-video-creator/
# Language: python3
# Date: 2026-04-27


class Solution:
    def mostPopularCreator(
        self, creators: List[str], ids: List[str], views: List[int]
    ) -> List[List[str]]:
        mp = {}
        for i in range(len(creators)):
            mp[creators[i]] = mp.get(creators[i], 0) + views[i]
        max_value = max(mp.values())
        res = []
        vals = []
        indexes = {}
        for k, v in mp.items():
            if v == max_value:
                indexes[k] = len(res)
                res.append([k, ""])
                vals.append(-1)
        for i in range(len(creators)):
            k = creators[i]
            if k in indexes:
                idx = indexes[k]
                if views[i] > vals[idx] or (
                    views[i] == vals[idx] and ids[i] < res[idx][1]
                ):
                    vals[idx] = views[i]
                    res[idx][1] = ids[i]
        return res

