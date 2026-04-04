#
# Problem: 583. Delete Operation for Two Strings
# Difficulty: Medium
# Link: https://leetcode.com/problems/delete-operation-for-two-strings/
# Language: python3
# Date: 2026-04-04


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        dp = [0] * (len(word1) + 1)
        for i in range(len(word2)):
            prv = 0
            for j in range(len(word1)):
                temp = dp[j + 1]
                if word2[i] == word1[j]:
                    dp[j + 1] = prv + 1
                else:
                    dp[j + 1] = max(dp[j + 1], dp[j])
                prv = temp
        return len(word1) + len(word2) - 2 * dp[-1]

