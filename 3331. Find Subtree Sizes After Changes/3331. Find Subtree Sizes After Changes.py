#
# Problem: 3331. Find Subtree Sizes After Changes
# Difficulty: Medium
# Link: https://leetcode.com/problems/find-subtree-sizes-after-changes/
# Language: python3
# Date: 2026-05-06


class Solution:
    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        links = [[] for _ in range(len(parent))]
        for i in range(1, len(parent)):
            links[parent[i]].append(i)
        nodes = [-1] * 26

        def dfs(i: int):
            chr = ord(s[i]) - ord("a")
            ori = nodes[chr]
            nodes[chr] = i
            for nxt in links[i]:
                dfs(nxt)
            nodes[chr] = ori
            if ori != -1:
                parent[i] = ori

        dfs(0)

        links = [[] for _ in range(len(parent))]
        for i in range(1, len(parent)):
            links[parent[i]].append(i)
        res = [0] * len(parent)

        def dfs_count(i: int) -> int:
            cnt = 1
            for nxt in links[i]:
                cnt += dfs_count(nxt)
            res[i] = cnt
            return cnt

        dfs_count(0)
        return res

