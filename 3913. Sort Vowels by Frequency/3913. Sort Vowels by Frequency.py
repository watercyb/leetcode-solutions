#
# Problem: 3913. Sort Vowels by Frequency
# Difficulty: Medium
# Link: https://leetcode.com/problems/sort-vowels-by-frequency/
# Language: python3
# Date: 2026-04-29


class Solution:
    def sortVowels(self, s: str) -> str:
        counts = Counter(s)
        arr = [
            ["a", counts["a"], s.find("a")],
            ["e", counts["e"], s.find("e")],
            ["i", counts["i"], s.find("i")],
            ["o", counts["o"], s.find("o")],
            ["u", counts["u"], s.find("u")],
        ]
        arr.sort(key=lambda x: (-x[1], x[2]))
        idx = 0
        res = []
        for i in range(len(s)):
            if s[i] == "a" or s[i] == "e" or s[i] == "i" or s[i] == "o" or s[i] == "u":
                if arr[idx][1] == 0:
                    idx += 1
                res.append(arr[idx][0])
                arr[idx][1] -= 1
            else:
                res.append(s[i])
        return "".join(res)

