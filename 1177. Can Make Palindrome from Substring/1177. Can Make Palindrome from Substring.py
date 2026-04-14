#
# Problem: 1177. Can Make Palindrome from Substring
# Difficulty: Medium
# Link: https://leetcode.com/problems/can-make-palindrome-from-substring/
# Language: python3
# Date: 2026-04-14


class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        counts = [0] * 26
        arr = [counts.copy()]
        for char in s:
            counts[ord(char) - ord("a")] += 1
            arr.append(counts.copy())
        res = []
        for query in queries:
            count = 0
            for i in range(26):
                count += (arr[query[1] + 1][i] - arr[query[0]][i]) % 2
            res.append(count // 2 <= query[2])
        return res

