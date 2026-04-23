#
# Problem: 2024. Maximize the Confusion of an Exam
# Difficulty: Medium
# Link: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
# Language: python3
# Date: 2026-04-23


class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        def getMax(target: str, k: int) -> int:
            res = 0
            j = 0
            for i in range(len(answerKey)):
                if answerKey[i] != target:
                    k -= 1
                while k < 0:
                    if answerKey[j] != target:
                        k += 1
                    j += 1
                res = max(res, i - j + 1)
            return res

        return max(getMax("T", k), getMax("F", k))

