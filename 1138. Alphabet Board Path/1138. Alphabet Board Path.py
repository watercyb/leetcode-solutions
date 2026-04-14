#
# Problem: 1138. Alphabet Board Path
# Difficulty: Medium
# Link: https://leetcode.com/problems/alphabet-board-path/
# Language: python3
# Date: 2026-04-14


class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        x = 0
        y = 0
        arr = []
        for char in target:
            num = ord(char) - ord("a")
            x_current = num // 5
            y_current = num % 5
            while x > x_current:
                arr.append("U")
                x -= 1
            while y > y_current:
                arr.append("L")
                y -= 1
            while x < x_current:
                arr.append("D")
                x += 1
            while y < y_current:
                arr.append("R")
                y += 1
            arr.append("!")
        return "".join(arr)

