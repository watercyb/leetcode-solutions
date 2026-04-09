#
# Problem: 809. Expressive Words
# Difficulty: Medium
# Link: https://leetcode.com/problems/expressive-words/
# Language: python3
# Date: 2026-04-09


class Solution:
    def expressiveWords(self, s: str, words: List[str]) -> int:
        def getCounts(s: str) -> List[List]:
            letters = []
            counts = []
            prv = s[0]
            cnt = 1
            for i in range(1, len(s)):
                if s[i] == prv:
                    cnt += 1
                else:
                    letters.append(prv)
                    counts.append(cnt)
                    prv = s[i]
                    cnt = 1
            letters.append(prv)
            counts.append(cnt)
            return [letters, counts]

        target = getCounts(s)
        res = 0
        for word in words:
            w = getCounts(word)
            if len(w[0]) != len(target[0]):
                continue
            isGood = True
            for i in range(len(w[0])):
                if (
                    w[0][i] != target[0][i]
                    or w[1][i] > target[1][i]
                    or (w[1][i] < target[1][i] and target[1][i] < 3)
                ):
                    isGood = False
                    break
            if isGood:
                res += 1
        return res

